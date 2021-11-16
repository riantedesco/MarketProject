package com.compasso.ProjetoMercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compasso.ProjetoMercado.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
