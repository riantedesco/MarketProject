package com.compasso.ProjetoMercado.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long Nome;

    private Double valor;

    private Long quantidade;

    @NotEmpty(message = "O produto deve possuir uma Marca")
    @NotNull(message = "O produto deve possuir uma Marca")
    private Long Marca;

    @NotEmpty(message = "O produto deve possuir um Setor Específico do Mercado")
    @NotNull(message = "O produto deve possuir um Setor Específico do Mercado")
    private Long Setor;

    public Produtos(Produtos produtos) {

    }
}
