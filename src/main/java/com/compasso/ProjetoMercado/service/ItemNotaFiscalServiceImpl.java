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
import com.compasso.ProjetoMercado.repository.ItemNotaFiscalRepository;
import com.compasso.ProjetoMercado.validation.Validation;

@Service
public class ItemNotaFiscalServiceImpl implements ItemNotaFiscalService {
	
	@Autowired
	private ItemNotaFiscalRepository itemNotaFiscalRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private Validation validation;

	@Override
	public ItemNotaFiscalDto salvar(ItemNotaFiscalFormDto body) {
		ItemNotaFiscal itemNotaFiscal = mapper.map(body, ItemNotaFiscal.class);
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
		if (itemNotaFiscal.isPresent() == true) {
			itemNotaFiscal.get().setQuantidade(body.getQuantidade());
			itemNotaFiscal.get().setNotaFiscal(body.getNotaFiscal());
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
