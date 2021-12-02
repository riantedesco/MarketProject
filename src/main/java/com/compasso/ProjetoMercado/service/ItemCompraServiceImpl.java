package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.ItemCompraDto;
import com.compasso.ProjetoMercado.entity.ItemCompra;
import com.compasso.ProjetoMercado.repository.ItemCompraRepository;

@Service
public class ItemCompraServiceImpl implements ItemCompraService {
	
	@Autowired
	private ItemCompraRepository itemCompraRepository;
	
	@Autowired
	private ModelMapper mapper;

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

}
