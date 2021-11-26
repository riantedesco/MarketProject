package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.AssociaFuncionarioFormDto;
import com.compasso.ProjetoMercado.dto.CaixaDto;
import com.compasso.ProjetoMercado.dto.CaixaFormDto;
import com.compasso.ProjetoMercado.dto.DesassociaFuncionarioFormDto;

public interface CaixaService {

	CaixaDto salvar(CaixaFormDto body);
	
	CaixaDto associarFuncionario(AssociaFuncionarioFormDto body);
	
	CaixaDto desassociarFuncionario(DesassociaFuncionarioFormDto body);
	
	List<CaixaDto> listar();
	
	CaixaDto procurar(Long id);
	
	CaixaDto atualizar(Long id, CaixaFormDto body);
	
	void remover(Long id);
}
