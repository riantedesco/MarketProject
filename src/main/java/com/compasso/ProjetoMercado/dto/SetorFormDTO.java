package com.compasso.ProjetoMercado.dto;

import com.compasso.ProjetoMercado.entity.option.nomeSetorOption;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Data
@Entity
@Getter
@Setter
public class SetorFormDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private nomeSetorOption Nome;
}
