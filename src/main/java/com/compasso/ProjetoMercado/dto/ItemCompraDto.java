package com.compasso.ProjetoMercado.dto;

import javax.persistence.Entity;

import com.compasso.ProjetoMercado.entity.Compra;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ItemCompraDto {

	private Long numero;
	
	private Long quantidade;
	
	private Double valorTotal;
	
	private Compra compra;
}
