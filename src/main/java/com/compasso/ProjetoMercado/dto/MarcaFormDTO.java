package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.entity.option.tipoMercadoriaOption;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;


@Data
@Entity
@Getter
@Setter
public class MarcaFormDTO {

    private Long Nome;

    @Enumerated(EnumType.STRING)
    private tipoMercadoriaOption tipoMercadoria;

}
