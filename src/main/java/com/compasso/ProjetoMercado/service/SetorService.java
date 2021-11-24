package com.compasso.ProjetoMercado.service;

import java.util.List;

import com.compasso.ProjetoMercado.dto.SetorDto;
import com.compasso.ProjetoMercado.dto.SetorFormDto;

public interface SetorService {
	
    SetorDto salvar(SetorFormDto body);
    
    List<SetorDto> listar();

    SetorDto procurar(Long id);

    SetorDto atualizar(Long id, SetorFormDto body);

    void remover(Long id);
}
