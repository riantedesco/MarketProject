package com.compasso.ProjetoMercado.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotaFiscalFormDto {
	
	private Long numero;
	
	private LocalDate dataHoraEntrada;

    private List<ItemNotaFiscalFormDto> itemNotaFiscal;
}
