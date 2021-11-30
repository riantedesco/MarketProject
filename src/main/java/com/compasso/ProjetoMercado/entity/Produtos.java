package com.compasso.ProjetoMercado.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Produtos {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Double valor;

    private Integer quantidade = 0;

    @NotNull(message = "O produto deve possuir uma marca")
    @ManyToOne
    private Marca marca;

    @NotNull(message = "O produto deve possuir um setor específico do mercado")
    @ManyToOne
    private Setor setor;

}
