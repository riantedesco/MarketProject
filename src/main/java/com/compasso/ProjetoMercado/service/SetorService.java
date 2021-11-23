package com.compasso.ProjetoMercado.service;


import com.compasso.ProjetoMercado.dto.SetorDTO;
import com.compasso.ProjetoMercado.dto.SetorFormDTO;

import java.util.Optional;

public interface SetorService {
    SetorDTO salvar(SetorFormDTO body);

    SetorDTO consultar(Long id);

    Optional atualizar(Long id, SetorFormDTO body);

    void excluir(Long id);
}
