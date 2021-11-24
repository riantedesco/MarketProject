package com.compasso.ProjetoMercado.dto;

import javax.persistence.Entity;

import com.compasso.ProjetoMercado.constants.tipoMercadoriaOption;

import lombok.Data;

@Data
@Entity
public class MarcaFormDto {
	
    private String Nome;

    private tipoMercadoriaOption tipoMercadoria;
}
