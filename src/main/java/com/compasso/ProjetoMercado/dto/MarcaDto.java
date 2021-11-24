package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.constants.tipoMercadoriaOption;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MarcaDto {

    private Long id;

    private String Nome;

    private tipoMercadoriaOption tipoMercadoria;
}
