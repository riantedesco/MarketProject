package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.entity.Produtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemCompraDto {

	private Long numero;
	
	private Integer quantidade;
	
	private Double valorTotal;
	
	private Produtos produto;
}
