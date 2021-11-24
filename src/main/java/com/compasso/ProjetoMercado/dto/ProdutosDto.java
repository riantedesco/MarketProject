package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.entity.Marca;
import com.compasso.ProjetoMercado.entity.Setor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutosDto {

    private Long id;

    private String Nome;

    private Double valor;

    private Long quantidade;

    private Marca Marca;

    private Setor Setor;
}
