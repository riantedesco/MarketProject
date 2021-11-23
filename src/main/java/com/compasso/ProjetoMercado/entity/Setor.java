package com.compasso.ProjetoMercado.entity;

import com.compasso.ProjetoMercado.entity.option.nomeSetorOption;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
@NoArgsConstructor
public class Setor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long Nome;

    public Setor(Setor setor) {

    }

    public static boolean isPresent() {
        return false;
    }

    public static Object get() {
        return null;
    }

    public void setNome(nomeSetorOption nome) {
    }
}
