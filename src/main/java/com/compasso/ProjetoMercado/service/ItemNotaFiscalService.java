package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.ItemNotaFiscalDto;

public interface ItemNotaFiscalService {
	
	List<ItemNotaFiscalDto> listar();
	
	ItemNotaFiscalDto procurar(Long id);
}