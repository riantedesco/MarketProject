package com.compasso.ProjetoMercado.dto;

import javax.persistence.Entity;

import com.compasso.ProjetoMercado.entity.NotaFiscal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ItemNotaFiscalFormDto {
	
	private Long quantidade;
	
	private NotaFiscal notaFiscal;
}
