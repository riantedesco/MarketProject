package com.compasso.ProjetoMercado.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CaixaDto {
	
	private Long id;
	
	private Boolean ativo;
	
	private String descricao;
	
	private FuncionarioDto funcionario;
}
