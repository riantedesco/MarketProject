package com.compasso.ProjetoMercado.dto;

import java.time.LocalDate;
import java.util.List;

import com.compasso.ProjetoMercado.entity.Caixa;
import com.compasso.ProjetoMercado.entity.Cliente;
import com.compasso.ProjetoMercado.entity.ItemCompra;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompraDto {
	
	private Long id;
	
	private LocalDate dataHora;
	
	private Double valorTotal;
	
	private Cliente cliente;
	
	private Caixa caixa;

    private List<ItemCompra> itemCompra;

	private Double desc = 0.05;
}
