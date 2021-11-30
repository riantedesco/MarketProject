package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.ItemNotaFiscalDto;
import com.compasso.ProjetoMercado.dto.ItemNotaFiscalFormDto;

public interface ItemNotaFiscalService {

	ItemNotaFiscalDto salvar(ItemNotaFiscalFormDto body);
	
	List<ItemNotaFiscalDto> listar();
	
	ItemNotaFiscalDto procurar(Long id);
	
	ItemNotaFiscalDto atualizar(Long id, ItemNotaFiscalFormDto body);
	
	void remover(Long id);
}