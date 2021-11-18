package com.compasso.ProjetoMercado.dto;

import javax.persistence.Entity;

import com.compasso.ProjetoMercado.entity.NotaFiscal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ItemNotaFiscalDto {

	private Long numero;
	
	private Long quantidade;
	
	private Double valorTotal;
	
	private NotaFiscal notaFiscal;
}
