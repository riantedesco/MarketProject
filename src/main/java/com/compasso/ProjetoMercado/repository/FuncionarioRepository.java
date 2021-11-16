package com.compasso.ProjetoMercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compasso.ProjetoMercado.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
}
