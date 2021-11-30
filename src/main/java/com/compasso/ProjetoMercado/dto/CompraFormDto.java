package com.compasso.ProjetoMercado.dto;

import java.time.LocalDate;
import java.util.List;

//github.com/riantedesco/ProjetoMercado.git
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompraFormDto {

	private LocalDate dataHora;
	
	private Long idCliente;
	
	private Long idCaixa;

    private List<ItemCompraFormDto> itemCompra;
}
