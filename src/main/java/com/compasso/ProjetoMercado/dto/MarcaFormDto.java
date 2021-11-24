package com.compasso.ProjetoMercado.dto;

import javax.persistence.Entity;

import com.compasso.ProjetoMercado.constants.TipoMercadoriaOption;

import lombok.Data;

@Data
@Entity
public class MarcaFormDto {
	
    private String Nome;

    private TipoMercadoriaOption tipoMercadoria;
}
