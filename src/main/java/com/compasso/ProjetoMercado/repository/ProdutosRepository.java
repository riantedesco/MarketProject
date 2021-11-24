package com.compasso.ProjetoMercado.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compasso.ProjetoMercado.entity.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
	
}
