package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.ItemCompraDto;
import com.compasso.ProjetoMercado.dto.ItemCompraFormDto;
import com.compasso.ProjetoMercado.entity.ItemCompra;
import com.compasso.ProjetoMercado.repository.ItemCompraRepository;
import com.compasso.ProjetoMercado.validation.DadosNulosValidation;

@Service
public class ItemCompraServiceImpl implements ItemCompraService {
	
	@Autowired
	private ItemCompraRepository itemCompraRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private DadosNulosValidation validation;

	@Override
	public ItemCompraDto salvar(ItemCompraFormDto body) {
		ItemCompra itemCompra = mapper.map(body, ItemCompra.class);
		validation.validaItemCompra(itemCompra);
		ItemCompra itemCompraResponse = this.itemCompraRepository.save(itemCompra);
		return mapper.map(itemCompraResponse, ItemCompraDto.class);
	}

	@Override
	public List<ItemCompraDto> listar() {
		List<ItemCompraDto> itensCompra = new ArrayList<>();
		itensCompra = this.itemCompraRepository.findAll().stream().map(i -> mapper.map(i, ItemCompraDto.class))
					.collect(Collectors.toList());
		return itensCompra;
	}

	@Override
	public ItemCompraDto procurar(Long id) {
		Optional<ItemCompra> itemCompra = this.itemCompraRepository.findById(id);
		if (itemCompra.isPresent() == true) {
			return mapper.map(itemCompra.get(), ItemCompraDto.class);
		}
		throw new RuntimeException("Item não encontrado");
	}

	@Override
	public ItemCompraDto atualizar(Long id, ItemCompraFormDto body) {
		Optional<ItemCompra> itemCompra = this.itemCompraRepository.findById(id);
		if (itemCompra.isPresent() == true) {
			itemCompra.get().setQuantidade(body.getQuantidade());
			itemCompra.get().setCompra(body.getCompra());
			ItemCompra i = this.itemCompraRepository.save(itemCompra.get());
			return mapper.map(i, ItemCompraDto.class);
		}
		throw new RuntimeException("Item não encontrado");
	}

	@Override
	public void remover(Long id) {
		Optional<ItemCompra> itemCompra = this.itemCompraRepository.findById(id);
		if (itemCompra.isPresent() == true) {
			this.itemCompraRepository.deleteById(id);
		} else {
			throw new RuntimeException("Item não encontrado");
		}
	}
}
