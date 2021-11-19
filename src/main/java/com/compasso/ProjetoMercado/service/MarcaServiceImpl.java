package com.compasso.ProjetoMercado.service;

import com.compasso.ProjetoMercado.entity.Marca;
import com.compasso.ProjetoMercado.repository.MarcaRepository;
import com.compasso.ProjetoMercado.dto.MarcaDTO;
import com.compasso.ProjetoMercado.dto.MarcaFormDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class MarcaServiceImpl implements MarcaService{
    @Autowired
    private MarcaRepository repository;

    @Autowired
    private ModelMapper mapper;


    @Override
    public MarcaDTO consultar(Long id) {
        Optional<Marca> Marca = this.repository.findById(id);
        if (Marca.isPresent() == true) {
            return mapper.map(Marca.get(), MarcaDTO.class);
        }
        throw new RuntimeException("Marca não encontrada");
    }


    @Override
    public MarcaDTO atualizar(Long id, MarcaFormDTO body) {
        Optional<Marca> Marca = this.repository.findById(id);
        if (Marca.isPresent() == true) {
            Marca.get().setNome(body.getNome());
            Marca mc = this.repository.save(Marca.get());
            return mapper.map(mc, MarcaDTO.class);
        }
        throw new RuntimeException("Marca não encontrada");
    }

    @Override
    public void excluir(Long id) {
        Marca Marca = this.repository.findById(id).get();
        this.repository.delete(Marca);
    }


}
