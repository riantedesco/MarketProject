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

    private String Nome;

    private Double valor;

    private Long quantidade;

    @NotEmpty(message = "O produto deve possuir uma marca")
    @NotNull(message = "O produto deve possuir uma marca")
    private Marca Marca;

    @NotEmpty(message = "O produto deve possuir um setor específico do mercado")
    @NotNull(message = "O produto deve possuir um setor específico do mercado")
    private Setor Setor;

}
