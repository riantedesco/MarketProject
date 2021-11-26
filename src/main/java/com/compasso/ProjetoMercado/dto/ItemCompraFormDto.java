package com.compasso.ProjetoMercado.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemCompraFormDto {
	
	private Integer quantidade;
	
	private Long idCompra;
	
	private Long idProduto;
}
