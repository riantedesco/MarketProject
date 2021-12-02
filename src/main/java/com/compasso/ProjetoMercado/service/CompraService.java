package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.CadastraItensCompraFormDto;
import com.compasso.ProjetoMercado.dto.CompraDto;
import com.compasso.ProjetoMercado.dto.CompraFormDto;

public interface CompraService {

	CompraDto salvar(CompraFormDto body);
	
	CompraDto cadastrarItens(Long id, CadastraItensCompraFormDto body);
	
	List<CompraDto> listar();
	
	CompraDto procurar(Long id);
	
	CompraDto atualizar(Long id, CompraFormDto body);
	
	void remover(Long id);
}
