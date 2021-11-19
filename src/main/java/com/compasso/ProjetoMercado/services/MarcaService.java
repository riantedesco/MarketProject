package com.compasso.ProjetoMercado.services;

import com.compasso.ProjetoMercado.dto.MarcaDTO;
import com.compasso.ProjetoMercado.dto.MarcaFormDTO;

public interface MarcaService {
    MarcaDTO consultar(Long id);

    MarcaDTO atualizar(Long id, MarcaFormDTO body);

    void excluir(Long id);
}
