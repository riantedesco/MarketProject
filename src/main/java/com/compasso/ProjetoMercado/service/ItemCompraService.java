package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.ItemCompraDto;
import com.compasso.ProjetoMercado.dto.ItemCompraFormDto;

public interface ItemCompraService {

	ItemCompraDto salvar(ItemCompraFormDto body);
	
	List<ItemCompraDto> listar();
	
	ItemCompraDto procurar(Long id);
	
	ItemCompraDto atualizar(Long id, ItemCompraFormDto body);
	
	void remover(Long id);
}
