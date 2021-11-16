package com.compasso.ProjetoMercado.dto;

import java.time.LocalDate;

import com.compasso.ProjetoMercado.entity.option.SexoOption;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FuncionarioDto {
	
	private Long id;

	private Long cpf;
	
	private String nome;

	private LocalDate dataNascimento;

	private SexoOption sexo;
}
