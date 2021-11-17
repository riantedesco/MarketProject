package com.compasso.ProjetoMercado.validation;

import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.entity.Caixa;
import com.compasso.ProjetoMercado.entity.Cliente;
import com.compasso.ProjetoMercado.entity.Funcionario;
import com.compasso.ProjetoMercado.exception.ErroDadosNulosException;

@Service
public class Validation {
	
	public void validaCliente (Cliente cliente) {
		if (cliente.getCpf() == null) {
			throw new ErroDadosNulosException("O CPF não pode ser nulo");
		} else if (cliente.getNome() == null) {
			throw new ErroDadosNulosException("O nome não pode ser nulo");
		} else if (cliente.getDataNascimento() == null) {
			throw new ErroDadosNulosException("A data de nascimento não pode ser nula");
		} else if (cliente.getSexo() == null) {
			throw new ErroDadosNulosException("O sexo não pode ser nulo");
		}
	}
	
	public void validaFuncionario (Funcionario funcionario) {
		if (funcionario.getCpf() == null) {
			throw new ErroDadosNulosException("O CPF não pode ser nulo");
		} else if (funcionario.getNome() == null) {
			throw new ErroDadosNulosException("O nome não pode ser nulo");
		} else if (funcionario.getDataNascimento() == null) {
			throw new ErroDadosNulosException("A data de nascimento não pode ser nula");
		} else if (funcionario.getSexo() == null) {
			throw new ErroDadosNulosException("O sexo não pode ser nulo");
		}
	}
	
	public void validaCaixa (Caixa caixa) {
		if (caixa.getAtivo() == null) {
			caixa.setAtivo(false);
		} 
	}
}
