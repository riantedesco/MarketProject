package com.compasso.ProjetoMercado.config;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.compasso.ProjetoMercado.util.TipoMercadoriaConverterEnum;

public class TipoMercadoriaConverterEnumConfig implements WebMvcConfigurer {
	
	@Override
	public void addFormatters (FormatterRegistry formatterRegistry) {
		formatterRegistry.addConverter(new TipoMercadoriaConverterEnum());
	}
}
