package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.NotaFiscalDto;
import com.compasso.ProjetoMercado.dto.NotaFiscalFormDto;

public interface NotaFiscalService {

	NotaFiscalDto salvar(NotaFiscalFormDto body);
	
	List<NotaFiscalDto> listar();
	
	NotaFiscalDto procurar(Long id);
	
	NotaFiscalDto atualizar(Long id, NotaFiscalFormDto body);
	
	void remover(Long id);
}
