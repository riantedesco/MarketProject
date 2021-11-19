package com.compasso.ProjetoMercado.service;

import com.compasso.ProjetoMercado.dto.ProdutosDTO;
import com.compasso.ProjetoMercado.dto.ProdutosFormDTO;

public interface ProdutosService {
    ProdutosDTO consultar(Long id);

    ProdutosDTO atualizar(Long id, ProdutosFormDTO body);

    void excluir(Long id);
}
