package com.compasso.ProjetoMercado.dto;

import java.time.LocalDate;
import java.util.List;

import com.compasso.ProjetoMercado.entity.ItemCompra;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompraFormDto {

	private LocalDate dataHora;
	
	private Long idCliente;
	
	private Long idCaixa;

    private List<ItemCompra> itemCompra;
}
