package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.ItemNotaFiscalDto;
import com.compasso.ProjetoMercado.entity.ItemNotaFiscal;
import com.compasso.ProjetoMercado.repository.ItemNotaFiscalRepository;

@Service
public class ItemNotaFiscalServiceImpl implements ItemNotaFiscalService {
	
	@Autowired
	private ItemNotaFiscalRepository itemNotaFiscalRepository;

	@Autowired
	private ModelMapper mapper;

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

}