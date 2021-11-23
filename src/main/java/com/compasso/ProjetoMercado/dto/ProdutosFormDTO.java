package com.compasso.ProjetoMercado.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;


@Data
@Entity
@NoArgsConstructor
public class ProdutosFormDTO {

    private Long Nome;

    private Double valor;

    private Long quantidade;

    private Long Marca;

    private Long Setor;
}
