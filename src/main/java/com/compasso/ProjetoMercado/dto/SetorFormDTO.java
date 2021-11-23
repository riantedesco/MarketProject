package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.entity.option.nomeSetorOption;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
public class SetorFormDTO {


    @Enumerated(EnumType.STRING)
    private nomeSetorOption Nome;
}
