package com.compasso.ProjetoMercado.service;

import com.compasso.ProjetoMercado.entity.Marca;
import com.compasso.ProjetoMercado.repository.MarcaRepository;
import com.compasso.ProjetoMercado.dto.MarcaDTO;
import com.compasso.ProjetoMercado.dto.MarcaFormDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Validation;
import java.util.Optional;


public class MarcaServiceImpl implements MarcaService{

    @Autowired
    private ModelMapper mapper;
    private Validation validation;
    private MarcaRepository marcaRepository;
    private MarcaRepository repository;


    @Override
    public MarcaDTO salvar(MarcaFormDTO body) {
        Marca marca = mapper.map(body, Marca.class);
        validation.buildDefaultValidatorFactory();
        new Marca(marca);
        Marca marcaResponse = this.marcaRepository.save(marca);
        return mapper.map(marcaResponse, MarcaDTO.class);
    }
    
    
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
