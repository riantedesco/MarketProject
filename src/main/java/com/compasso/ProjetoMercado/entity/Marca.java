package com.compasso.ProjetoMercado.entity;

import com.compasso.ProjetoMercado.constants.TipoMercadoriaOption;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoMercadoriaOption tipoMercadoria;

}
