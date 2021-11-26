package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.entity.Compra;
import com.compasso.ProjetoMercado.entity.Produtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemCompraFormDto {
	
	private Integer quantidade;
	
	private Compra compra;
	
	private Produtos produto;
}
