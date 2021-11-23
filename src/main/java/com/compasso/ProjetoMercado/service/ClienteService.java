package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.ClienteDto;
import com.compasso.ProjetoMercado.dto.ClienteFormDto;

public interface ClienteService {

	ClienteDto salvar(ClienteFormDto body);
	
	List<ClienteDto> listar();
	
	ClienteDto procurar(Long id);
	
	ClienteDto atualizar(Long id, ClienteFormDto body);
	
	void remover(Long id);
}
