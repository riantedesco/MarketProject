package com.compasso.ProjetoMercado.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CadastraItensCompraFormDto {

    private List<ItemCompraFormDto> itemCompra;
}
