package com.compasso.ProjetoMercado.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class NotaFiscal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long numero;
	
	private LocalDateTime dataHoraEntrada;
	
	private Double valorTotal = 0.00;

	@OneToMany(orphanRemoval = true)
    private List<ItemNotaFiscal> itemNotaFiscal;
}
