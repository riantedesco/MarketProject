package com.compasso.ProjetoMercado.service;

import com.compasso.ProjetoMercado.dto.MarcaDTO;
import com.compasso.ProjetoMercado.dto.MarcaFormDTO;

public interface MarcaService {
    MarcaDTO salvar(MarcaFormDTO body);

    MarcaDTO consultar(Long id);

    MarcaDTO atualizar(Long id, MarcaFormDTO body);

    void excluir(Long id);

}
