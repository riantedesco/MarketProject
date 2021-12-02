package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.ItemCompraDto;

public interface ItemCompraService {

	List<ItemCompraDto> listar();
	
	ItemCompraDto procurar(Long id);
	
}
