package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.entity.option.tipoMercadoriaOption;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
public class MarcaDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long Nome;

    @Enumerated(EnumType.STRING)
    private tipoMercadoriaOption tipoMercadoria;
}
