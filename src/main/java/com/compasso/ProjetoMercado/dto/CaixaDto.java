package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.entity.Funcionario;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CaixaDto {
	
	private Long id;
	
	private Boolean ativo;
	
	private Funcionario funcionario;
}
