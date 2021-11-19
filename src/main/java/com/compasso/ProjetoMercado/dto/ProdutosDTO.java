package com.compasso.ProjetoMercado.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
@Getter
@Setter
public class ProdutosDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long Nome;

    private Double valor;

    private Long quantidade;

    private Long Marca;

    private Long Setor
}
