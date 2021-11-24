package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.MarcaDto;
import com.compasso.ProjetoMercado.dto.MarcaFormDto;

public interface MarcaService {
	
    MarcaDto salvar(MarcaFormDto body);
    
    List<MarcaDto> listar();

    MarcaDto procurar(Long id);

    MarcaDto atualizar(Long id, MarcaFormDto body);

    void remover(Long id);
}
