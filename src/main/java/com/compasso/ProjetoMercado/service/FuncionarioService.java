package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.FuncionarioDto;
import com.compasso.ProjetoMercado.dto.FuncionarioFormDto;

public interface FuncionarioService {

	FuncionarioDto salvar(FuncionarioFormDto body);
	
	List<FuncionarioDto> listar();
	
	FuncionarioDto procurar(Long id);
	
	FuncionarioDto atualizar(Long id, FuncionarioFormDto body);
	
	void remover(Long id);
}
