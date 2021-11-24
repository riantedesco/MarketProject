package com.compasso.ProjetoMercado.util;

import org.springframework.core.convert.converter.Converter;

import com.compasso.ProjetoMercado.constants.NomeSetorOption;

public class NomeSetorConverterEnum implements Converter <String, NomeSetorOption> {

	@Override
	public NomeSetorOption convert(String nomeSetor) {
		return NomeSetorOption.valueOf(nomeSetor.toUpperCase());
	}
}
