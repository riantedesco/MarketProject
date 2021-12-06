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

import com.compasso.ProjetoMercado.dto.CadastraItensCompraFormDto;
import com.compasso.ProjetoMercado.dto.CompraDto;
import com.compasso.ProjetoMercado.dto.CompraFormDto;
import com.compasso.ProjetoMercado.dto.ItemCompraFormDto;
import com.compasso.ProjetoMercado.entity.Caixa;
import com.compasso.ProjetoMercado.entity.Cliente;
import com.compasso.ProjetoMercado.entity.Compra;
import com.compasso.ProjetoMercado.entity.ItemCompra;
import com.compasso.ProjetoMercado.entity.Produtos;
import com.compasso.ProjetoMercado.exception.ErroCaixaInativoException;
import com.compasso.ProjetoMercado.exception.ErroChaveEstrangeiraException;
import com.compasso.ProjetoMercado.exception.ErroEstqInsuficienteException;
import com.compasso.ProjetoMercado.repository.CaixaRepository;
import com.compasso.ProjetoMercado.repository.ClienteRepository;
import com.compasso.ProjetoMercado.repository.CompraRepository;
import com.compasso.ProjetoMercado.repository.ItemCompraRepository;
import com.compasso.ProjetoMercado.repository.ProdutosRepository;
import com.compasso.ProjetoMercado.validation.DadosNulosValidation;

@Service
public class CompraServiceImpl implements CompraService {
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private CaixaRepository caixaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ItemCompraRepository itemCompraRepository;
	
	@Autowired
	private ProdutosRepository produtosRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private DadosNulosValidation validation;
	
	@Override
	public CompraDto salvar(CompraFormDto body) {
	   	mapper.getConfiguration().setAmbiguityIgnored(true);
		Compra compra = mapper.map(body, Compra.class);
		
		if (body.getIdCaixa() != null) {
			Optional<Caixa> caixa = this.caixaRepository.findById(body.getIdCaixa());
			if (caixa.isPresent() == true) {
				if (caixa.get().getAtivo() == true) {
					compra.setCaixa(caixa.get());
				} else {
					throw new ErroCaixaInativoException("O caixa informado está inativo");
				}
			} else {
				throw new ErroChaveEstrangeiraException("Caixa não encontrado");
			}
		}
		
		if (body.getIdCliente() != null) {
			Optional<Cliente> cliente = this.clienteRepository.findById(body.getIdCliente());
			if(cliente.isPresent() == true) {
				compra.setCliente(cliente.get());
			} else {
				throw new ErroChaveEstrangeiraException("Cliente não encontrado");
			}
		}
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataFormatada = LocalDateTime.now().format(dtf);
		compra.setDataHora(LocalDateTime.parse(dataFormatada, dtf));
		
		validation.validaCompra(compra);
		Compra compraResponse = this.compraRepository.save(compra);
		return mapper.map(compraResponse, CompraDto.class);
	}
	
	@Override
	public CompraDto cadastrarItens(Long id, CadastraItensCompraFormDto body) {
		Optional<Compra> compra = this.compraRepository.findById(id);
		if (compra.isPresent() == true) {
			List<ItemCompraFormDto> listaItemCompra = body.getItemCompra();
			
			for(ItemCompraFormDto i : listaItemCompra) {
				ItemCompra itemCompra = mapper.map(body.getItemCompra(), ItemCompra.class);
				if (i.getIdProduto() != null) {
				    Optional<Produtos> produto = this.produtosRepository.findById(i.getIdProduto());
					if (produto.isPresent() == true) {
						
						itemCompra.setProduto(produto.get());
						itemCompra.setQuantidade(i.getQuantidade());
						itemCompra.setValorTotal(i.getQuantidade() * produto.get().getValor());
						
						if (produto.get().getQuantidade() >= i.getQuantidade()) {
							produto.get().setQuantidade(produto.get().getQuantidade() - i.getQuantidade());
						} else {
							throw new ErroEstqInsuficienteException("Produto " + produto.get().getNome() + " não possui estoque suficiente");
						}
						
						validation.validaItemCompra(itemCompra);
						this.itemCompraRepository.save(itemCompra);

						compra.get().setValorTotal(compra.get().getValorTotal() + itemCompra.getValorTotal());
						compra.get().getItemCompra().add(itemCompra);
					} else {
						throw new ErroChaveEstrangeiraException("Produto não encontrado");
					}
			    }
			}
			
			if (compra.get().getCliente() != null ) {
				// Cálculo Desconto 5%
				compra.get().setValorTotal(compra.get().getValorTotal() - (compra.get().getValorTotal() * 0.05));
			}
			
			Compra compraResponse = this.compraRepository.save(compra.get());
			return mapper.map(compraResponse, CompraDto.class);
		} else {
			throw new ErroChaveEstrangeiraException("Nota fiscal não encontrada");
		}
	}

	@Override
	public List<CompraDto> listar() {
		List<CompraDto> compras = new ArrayList<>();
		compras = this.compraRepository.findAll().stream().map(c -> mapper.map(c, CompraDto.class))
					.collect(Collectors.toList());
		return compras;
	}

	@Override
	public CompraDto procurar(Long id) {
		Optional<Compra> compra = this.compraRepository.findById(id);
		if (compra.isPresent() == true) {
			return mapper.map(compra.get(), CompraDto.class);
		}
		throw new RuntimeException("Compra não encontrada");
	}

	@Override
	public CompraDto atualizar(Long id, CompraFormDto body) {
		Optional<Compra> compra = this.compraRepository.findById(id);
		Optional<Caixa> caixa = this.caixaRepository.findById(body.getIdCaixa());
		Optional<Cliente> cliente = this.clienteRepository.findById(body.getIdCliente());
		if (compra.isPresent() == true) {
			if (caixa.isPresent() == true) {
    			compra.get().setCaixa(caixa.get());
    		} else {
    			throw new ErroChaveEstrangeiraException("Caixa não encontrado");
    		}
            if (cliente.isPresent() == true) {
    			compra.get().setCliente(cliente.get());
    		} else {
    			throw new ErroChaveEstrangeiraException("Cliente não encontrado");
    		}
			Compra c = this.compraRepository.save(compra.get());
			return mapper.map(c, CompraDto.class);
		}
		throw new RuntimeException("Compra não encontrada");
	}

	@Override
	public void remover(Long id) {
		Optional<Compra> compra = this.compraRepository.findById(id);
		if (compra.isPresent() == true) {
			List<ItemCompra> listaItemCompra = compra.get().getItemCompra();
			for(ItemCompra i : listaItemCompra) {
				Optional<Produtos> produto = this.produtosRepository.findById(i.getProduto().getId());
				produto.get().setQuantidade(produto.get().getQuantidade() + i.getQuantidade());
			}
			this.compraRepository.deleteById(id);
		} else {
			throw new RuntimeException("Compra não encontrada");
		}
	}
}
