package com.compasso.ProjetoMercado.Repository;

import com.compasso.ProjetoMercado.Entity.Marca;

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
