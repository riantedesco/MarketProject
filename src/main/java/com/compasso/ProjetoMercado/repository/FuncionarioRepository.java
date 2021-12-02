package com.compasso.ProjetoMercado.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.compasso.ProjetoMercado.entity.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

	@Query("SELECT f FROM Funcionario f WHERE f.cpf LIKE :cpf")
	Optional<Funcionario> findByCpf(String cpf);

}
