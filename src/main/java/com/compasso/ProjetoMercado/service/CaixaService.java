package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.CaixaDto;
import com.compasso.ProjetoMercado.dto.CaixaFormDto;

public interface CaixaService {

	CaixaDto salvar(CaixaFormDto body);
	
	List<CaixaDto> listar();
	
	CaixaDto procurar(Long id);
	
	CaixaDto atualizar(Long id, CaixaFormDto body);
	
	void remover(Long id);
}
