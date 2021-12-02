package com.compasso.ProjetoMercado.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotaFiscalDto {
	
	private Long id;
	
	private Long numero;
	
	private LocalDate dataHoraEntrada;
	
	private Double valorTotal;

    private List<ItemNotaFiscalDto> itemNotaFiscal;
}
