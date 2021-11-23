package com.compasso.ProjetoMercado.entity;

import com.compasso.ProjetoMercado.entity.option.tipoMercadoriaOption;
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

    private Long Nome;

    @Enumerated(EnumType.STRING)
    private tipoMercadoriaOption tipoMercadoria;

    public Marca(Marca marca) {

    }
}
