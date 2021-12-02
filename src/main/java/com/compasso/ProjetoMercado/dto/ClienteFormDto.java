package com.compasso.ProjetoMercado.dto;

import java.time.LocalDate;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@NoArgsConstructor
public class ClienteFormDto {

	@CPF(message = "Campo Inválido")
	private String cpf;
	
	private String nome;

	private LocalDate dataNascimento;

	private String sexo;
}
