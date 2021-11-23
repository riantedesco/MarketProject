package com.compasso.ProjetoMercado.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

import com.compasso.ProjetoMercado.entity.ItemNotaFiscal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class NotaFiscalFormDto {
	
	private Long numero;
	
	private LocalDate dataHoraEntrada;

    private List<ItemNotaFiscal> itemNotaFiscal;
}
