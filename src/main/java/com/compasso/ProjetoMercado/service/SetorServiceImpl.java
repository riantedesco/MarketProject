package com.compasso.ProjetoMercado.service;

import com.compasso.ProjetoMercado.dto.SetorDTO;
import com.compasso.ProjetoMercado.dto.SetorFormDTO;
import com.compasso.ProjetoMercado.entity.Setor;
import com.compasso.ProjetoMercado.repository.SetorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Validation;
import java.util.Optional;


public class SetorServiceImpl implements SetorService{
    @Autowired
    private SetorRepository repository;

    @Autowired
    private ModelMapper mapper;
    private Validation validation;
    private SetorRepository SetorRepository;


    @Override
    public SetorDTO salvar(SetorFormDTO body) {
        Setor setor = mapper.map(body, Setor.class);
        validation.buildDefaultValidatorFactory();
        new Setor(setor);
        Setor SetorResponse = this.SetorRepository.save(setor);
        return mapper.map(SetorResponse, SetorDTO.class);
    }


    @Override
    public SetorDTO consultar(Long id) {
        Optional<Setor> Produtos = this.repository.findById(id);
        if (Setor.isPresent()) {
            return mapper.map(Setor.get(), SetorDTO.class);
        }
        throw new RuntimeException("Setor não encontrado");
    }

    @Override
    public Optional atualizar(Long id, SetorFormDTO body) {
        Optional<Setor> Setor = this.repository.findById(id);
        if (Setor.isPresent()) {
            Setor.get().setNome(body.getNome());
            Setor St = this.repository.save(Setor.get());
            Optional<Object> mapper = Optional.empty();
            return mapper.map(St, SetorDTO.class);
        }
        throw new RuntimeException("Setor não encontrado");
    }


    @Override
    public void excluir(Long id) {
        Setor Setor = this.repository.findById(id).get();
        this.repository.delete(Setor);
    }
}
