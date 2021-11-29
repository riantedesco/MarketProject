package com.compasso.ProjetoMercado.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

import com.compasso.ProjetoMercado.entity.Caixa;
import com.compasso.ProjetoMercado.entity.Cliente;
import com.compasso.ProjetoMercado.entity.ItemCompra;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CompraFormDto {

	private LocalDate dataHora;
	
	private Long idCliente;
	
	private Long idCaixa;

    private List<ItemCompra> itemCompra;
}
