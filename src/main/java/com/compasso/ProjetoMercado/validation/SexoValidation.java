package com.compasso.ProjetoMercado.validation;

import java.util.Arrays;
import java.util.List;

import com.compasso.ProjetoMercado.entity.Cliente;
import com.compasso.ProjetoMercado.exception.ErroSexoException;

public class SexoValidation {

	private String masculino = "Masculino";
	private String feminino = "Feminino";
	
	List<String> listaSexo = Arrays.asList(masculino, feminino);

	public void validaSexoCliente (Cliente cliente) {
		String x = cliente.getSexo();
		
		if (!listaSexo.contains(x)) {
			throw new ErroSexoException("O sexo " + x + " é inválido");
		}
	}
}
