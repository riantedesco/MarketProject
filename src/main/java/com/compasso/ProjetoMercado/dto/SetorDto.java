package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.constants.nomeSetorOption;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SetorDto {

    private Long id;

    private nomeSetorOption nome;
}
