package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.entity.Funcionario;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CaixaFormDto {
	
	private String descricao;
	
	private String senha;
	
	private Funcionario funcionario;
}
