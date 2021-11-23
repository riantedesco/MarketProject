package com.compasso.ProjetoMercado.util;

import org.springframework.core.convert.converter.Converter;

import com.compasso.ProjetoMercado.constants.SexoOption;

public class SexoConverterEnum implements Converter <String, SexoOption> {

	@Override
	public SexoOption convert(String sexo) {
		return SexoOption.valueOf(sexo.toUpperCase());
	}
}
