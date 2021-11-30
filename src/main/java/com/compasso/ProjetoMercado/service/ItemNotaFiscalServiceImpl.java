package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.ItemNotaFiscalDto;
import com.compasso.ProjetoMercado.dto.ItemNotaFiscalFormDto;
import com.compasso.ProjetoMercado.entity.ItemNotaFiscal;
import com.compasso.ProjetoMercado.entity.Produtos;
import com.compasso.ProjetoMercado.exception.ErroChaveEstrangeiraException;
import com.compasso.ProjetoMercado.repository.ItemNotaFiscalRepository;
import com.compasso.ProjetoMercado.repository.ProdutosRepository;
import com.compasso.ProjetoMercado.validation.DadosNulosValidation;

@Service
public class ItemNotaFiscalServiceImpl implements ItemNotaFiscalService {
	
	@Autowired
	private ItemNotaFiscalRepository itemNotaFiscalRepository;
	
	@Autowired
	private ProdutosRepository produtosRepository;
	
//	@Autowired
//	private NotaFiscalRepository notaFiscalRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private DadosNulosValidation validation;

	@Override
	public ItemNotaFiscalDto salvar(ItemNotaFiscalFormDto body) {
		mapper.getConfiguration().setAmbiguityIgnored(true);
		ItemNotaFiscal itemNotaFiscal = mapper.map(body, ItemNotaFiscal.class);
		
		if (body.getIdProduto() != null) {
			Optional<Produtos> produtos = this.produtosRepository.findById(body.getIdProduto());
			if (produtos.isPresent() == true) {
				itemNotaFiscal.setProduto(produtos.get());
			} else {
				throw new ErroChaveEstrangeiraException("Produto não encontrado");
			}
		}
		
//		if (body.getIdNotaFiscal() != null) {
//			Optional<NotaFiscal> notaFiscal = this.notaFiscalRepository.findById(body.getIdNotaFiscal());
//			if (notaFiscal.isPresent() == true) {
//				itemNotaFiscal.setNotaFiscal(notaFiscal.get());
//			} else {
//				throw new ErroChaveEstrangeiraException("Nota fiscal não encontrada");
//			}
//		}
		
		itemNotaFiscal.setValorTotal(itemNotaFiscal.getQuantidade() * itemNotaFiscal.getProduto().getValor());
		
		validation.validaItemNotaFiscal(itemNotaFiscal);
		ItemNotaFiscal itemNotaFiscalResponse = this.itemNotaFiscalRepository.save(itemNotaFiscal);
		return mapper.map(itemNotaFiscalResponse, ItemNotaFiscalDto.class);
	}

	@Override
	public List<ItemNotaFiscalDto> listar() {
		List<ItemNotaFiscalDto> itensNotaFiscal = new ArrayList<>();
		itensNotaFiscal = this.itemNotaFiscalRepository.findAll().stream().map(i -> mapper.map(i, ItemNotaFiscalDto.class))
					.collect(Collectors.toList());
		return itensNotaFiscal;
	}

	@Override
	public ItemNotaFiscalDto procurar(Long id) {
		Optional<ItemNotaFiscal> itemNotaFiscal = this.itemNotaFiscalRepository.findById(id);
		if (itemNotaFiscal.isPresent() == true) {
			return mapper.map(itemNotaFiscal.get(), ItemNotaFiscalDto.class);
		}
		throw new RuntimeException("Item não encontrado");
	}

	@Override
	public ItemNotaFiscalDto atualizar(Long id, ItemNotaFiscalFormDto body) {
		Optional<ItemNotaFiscal> itemNotaFiscal = this.itemNotaFiscalRepository.findById(id);
		Optional<Produtos> produtos = this.produtosRepository.findById(body.getIdProduto());
//        Optional<NotaFiscal> notaFiscal = this.notaFiscalRepository.findById(body.getIdNotaFiscal());
		if (itemNotaFiscal.isPresent() == true) {
			itemNotaFiscal.get().setQuantidade(body.getQuantidade());
			if (produtos.isPresent() == true) {
				itemNotaFiscal.get().setProduto(produtos.get());
    		} else {
    			throw new ErroChaveEstrangeiraException("Produto não encontrado");
    		}
//            if (notaFiscal.isPresent() == true) {
//            	itemNotaFiscal.get().setNotaFiscal(notaFiscal.get());
//    		} else {
//    			throw new ErroChaveEstrangeiraException("Nota fiscal não encontrada");
//    		}
			ItemNotaFiscal i = this.itemNotaFiscalRepository.save(itemNotaFiscal.get());
			return mapper.map(i, ItemNotaFiscalDto.class);
		}
		throw new RuntimeException("Item não encontrado");
	}

	@Override
	public void remover(Long id) {
		Optional<ItemNotaFiscal> itemNotaFiscal = this.itemNotaFiscalRepository.findById(id);
		if (itemNotaFiscal.isPresent() == true) {
			this.itemNotaFiscalRepository.deleteById(id);
		} else {
			throw new RuntimeException("Item não encontrado");
		}
	}
}