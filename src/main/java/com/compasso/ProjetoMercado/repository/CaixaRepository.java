package com.compasso.ProjetoMercado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compasso.ProjetoMercado.entity.Caixa;

public interface CaixaRepository extends JpaRepository<Caixa, Long> {

	Optional<Caixa> findByDescricao(String descricao);
}
