package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.constants.TipoMercadoriaOption;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MarcaFormDto {
	
    private String nome;

    private TipoMercadoriaOption tipoMercadoria;
}
