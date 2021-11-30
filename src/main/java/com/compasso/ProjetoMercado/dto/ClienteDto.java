package com.compasso.ProjetoMercado.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClienteDto {
	
	private Long id;

	//@CPF
	private Long cpf;
	
	private String nome;

	private LocalDate dataNascimento;

	private String sexo;
}
