package com.compasso.ProjetoMercado.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemNotaFiscalFormDto {
	
	private Integer quantidade;
	
	private Long idNotaFiscal;
	
	private Long idProduto;
}
