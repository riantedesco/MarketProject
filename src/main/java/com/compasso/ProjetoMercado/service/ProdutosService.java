package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.ProdutosDto;
import com.compasso.ProjetoMercado.dto.ProdutosFormDto;

public interface ProdutosService {
	
    ProdutosDto salvar(ProdutosFormDto body);
    
    List<ProdutosDto> listar();

    ProdutosDto procurar(Long id);

    ProdutosDto atualizar(Long id, ProdutosFormDto body);

    void remover(Long id);
}
