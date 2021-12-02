package com.compasso.ProjetoMercado.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.CadastraItensNotaFormDto;
import com.compasso.ProjetoMercado.dto.ItemNotaFiscalFormDto;
import com.compasso.ProjetoMercado.dto.NotaFiscalDto;
import com.compasso.ProjetoMercado.dto.NotaFiscalFormDto;
import com.compasso.ProjetoMercado.entity.ItemNotaFiscal;
import com.compasso.ProjetoMercado.entity.NotaFiscal;
import com.compasso.ProjetoMercado.entity.Produtos;
import com.compasso.ProjetoMercado.exception.ErroChaveEstrangeiraException;
import com.compasso.ProjetoMercado.repository.ItemNotaFiscalRepository;
import com.compasso.ProjetoMercado.repository.NotaFiscalRepository;
import com.compasso.ProjetoMercado.repository.ProdutosRepository;
import com.compasso.ProjetoMercado.validation.DadosNulosValidation;

@Service
public class NotaFiscalServiceImpl implements NotaFiscalService {
	
	@Autowired
	private NotaFiscalRepository notaFiscalRepository;
	
	@Autowired
	private ItemNotaFiscalRepository itemNotaFiscalRepository;
	
	@Autowired
	private ProdutosRepository produtosRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private DadosNulosValidation validation;

	@Override
	public NotaFiscalDto salvar(NotaFiscalFormDto body) {
		NotaFiscal notaFiscal = mapper.map(body, NotaFiscal.class);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = LocalDateTime.now().format(dtf);
		notaFiscal.setDataHoraEntrada(LocalDateTime.parse(dataFormatada, dtf));
		
		validation.validaNotaFiscal(notaFiscal);
		NotaFiscal notaFiscalResponse = this.notaFiscalRepository.save(notaFiscal);
		return mapper.map(notaFiscalResponse, NotaFiscalDto.class);
	}
	
	@Override
	public NotaFiscalDto cadastrarItens(Long id, CadastraItensNotaFormDto body) {
		Optional<NotaFiscal> notaFiscal = this.notaFiscalRepository.findById(id);
		if (notaFiscal.isPresent() == true) {
			List<ItemNotaFiscalFormDto> listaItemNotaFiscal = body.getItemNotaFiscal();
			
			for(ItemNotaFiscalFormDto i : listaItemNotaFiscal) {
				ItemNotaFiscal itemNotaFiscal = mapper.map(body.getItemNotaFiscal(), ItemNotaFiscal.class);
				if (i.getIdProduto() != null) {
				    Optional<Produtos> produto = this.produtosRepository.findById(i.getIdProduto());
					if (produto.isPresent() == true) {
						
						itemNotaFiscal.setProduto(produto.get());
						itemNotaFiscal.setQuantidade(i.getQuantidade());
						itemNotaFiscal.setValorTotal(i.getQuantidade() * produto.get().getValor());
						
						produto.get().setQuantidade(produto.get().getQuantidade() + i.getQuantidade());
			
						validation.validaItemNotaFiscal(itemNotaFiscal);
						this.itemNotaFiscalRepository.save(itemNotaFiscal);
	
						notaFiscal.get().setValorTotal(notaFiscal.get().getValorTotal() + itemNotaFiscal.getValorTotal());
						notaFiscal.get().getItemNotaFiscal().add(itemNotaFiscal);
					} else {
						throw new ErroChaveEstrangeiraException("Produto não encontrado");
					}
			    }
			}
			NotaFiscal notaFiscalResponse = this.notaFiscalRepository.save(notaFiscal.get());
			return mapper.map(notaFiscalResponse, NotaFiscalDto.class);
		} else {
			throw new ErroChaveEstrangeiraException("Nota fiscal não encontrada");
		}
	}
	
	@Override
	public List<NotaFiscalDto> listar() {
		List<NotaFiscalDto> notasFiscais = new ArrayList<>();
		notasFiscais = this.notaFiscalRepository.findAll().stream().map(nf -> mapper.map(nf, NotaFiscalDto.class))
					.collect(Collectors.toList());
		return notasFiscais;
	}

	@Override
	public NotaFiscalDto procurar(Long id) {
		Optional<NotaFiscal> notaFiscal = this.notaFiscalRepository.findById(id);
		if (notaFiscal.isPresent() == true) {
			return mapper.map(notaFiscal.get(), NotaFiscalDto.class);
		}
		throw new RuntimeException("Nota fiscal não encontrada");
	}

	@Override
	public NotaFiscalDto atualizar(Long id, NotaFiscalFormDto body) {
		Optional<NotaFiscal> notaFiscal = this.notaFiscalRepository.findById(id);
		if (notaFiscal.isPresent() == true) {
			notaFiscal.get().setNumero(body.getNumero());
			NotaFiscal nf = this.notaFiscalRepository.save(notaFiscal.get());
			return mapper.map(nf, NotaFiscalDto.class);
		}
		throw new RuntimeException("Nota fiscal não encontrada");
	}

	@Override
	public void remover(Long id) {
		Optional<NotaFiscal> notaFiscal = this.notaFiscalRepository.findById(id);
		if (notaFiscal.isPresent() == true) {
			List<ItemNotaFiscal> listaItemNotaFiscal = notaFiscal.get().getItemNotaFiscal();
			for(ItemNotaFiscal i : listaItemNotaFiscal) {
				Optional<Produtos> produto = this.produtosRepository.findById(i.getProduto().getId());
				produto.get().setQuantidade(produto.get().getQuantidade() - i.getQuantidade());
			}
			this.notaFiscalRepository.deleteById(id);
		} else {
			throw new RuntimeException("Nota fiscal não encontrada");
		}
	}
}
