package com.compasso.ProjetoMercado.repository;

import com.compasso.ProjetoMercado.entity.Marca;

import java.util.Optional;

public class MarcaRepository {
    public Optional<Marca> findById(Long id) {
        return null;
    }

    public void delete(Marca marca) {
    }

    public Marca save(Marca marca) {
        return marca;
    }
}
