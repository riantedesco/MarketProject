package com.compasso.ProjetoMercado.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class NotaFiscalDto {
	
	private Long id;
	
	private Long numero;
	
	private LocalDateTime dataHoraEntrada;
	
	private Double valorTotal;
	
	private FuncionarioDto funcionario;

    private List<ItemNotaFiscalDto> itemNotaFiscal;
}
