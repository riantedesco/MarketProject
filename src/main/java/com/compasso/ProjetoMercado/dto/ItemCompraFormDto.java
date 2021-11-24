package com.compasso.ProjetoMercado.dto;

import javax.persistence.Entity;

import com.compasso.ProjetoMercado.entity.Compra;
import com.compasso.ProjetoMercado.entity.Produtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ItemCompraFormDto {
	
	private Long quantidade;
	
	private Compra compra;
	
	private Produtos produto;
}
