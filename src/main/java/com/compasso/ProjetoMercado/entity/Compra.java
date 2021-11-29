package com.compasso.ProjetoMercado.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private LocalDate dataHora;

	private Double valorTotal = 0.00;

	@ManyToOne
	private Cliente cliente;

	@ManyToOne
	private Caixa caixa;

	@OneToMany
	private List<ItemCompra> itemCompra;

}
