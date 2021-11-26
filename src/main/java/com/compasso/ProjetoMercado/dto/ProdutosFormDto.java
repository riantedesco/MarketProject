package com.compasso.ProjetoMercado.dto;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProdutosFormDto {

    private String nome;

    private Double valor;

    private Long idMarca;

    private Long idSetor;
}
