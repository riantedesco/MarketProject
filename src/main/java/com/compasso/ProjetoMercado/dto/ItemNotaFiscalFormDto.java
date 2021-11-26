package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.entity.NotaFiscal;
import com.compasso.ProjetoMercado.entity.Produtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemNotaFiscalFormDto {
	
	private Integer quantidade;
	
	private NotaFiscal notaFiscal;
	
	private Produtos produto;
}
