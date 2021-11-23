package com.compasso.ProjetoMercado.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.compasso.ProjetoMercado.constants.SexoOption;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long cpf;
	
	private String nome;

	private LocalDate dataNascimento;

	@Enumerated(EnumType.STRING)
	private SexoOption sexo;
}
