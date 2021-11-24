package com.compasso.ProjetoMercado.util;

import org.springframework.core.convert.converter.Converter;

import com.compasso.ProjetoMercado.constants.TipoMercadoriaOption;

public class TipoMercadoriaConverterEnum implements Converter <String, TipoMercadoriaOption> {

	@Override
	public TipoMercadoriaOption convert(String tipoMercadoria) {
		return TipoMercadoriaOption.valueOf(tipoMercadoria.toUpperCase());
	}
}
