package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.SetorDto;
import com.compasso.ProjetoMercado.dto.SetorFormDto;
import com.compasso.ProjetoMercado.entity.Setor;
import com.compasso.ProjetoMercado.repository.SetorRepository;
import com.compasso.ProjetoMercado.validation.DadosNulosValidation;

@Service
public class SetorServiceImpl implements SetorService {

	@Autowired
	private SetorRepository setorRepository;
	
    @Autowired
    private ModelMapper mapper;
    
    @Autowired
	private DadosNulosValidation validation;

    @Override
    public SetorDto salvar(SetorFormDto body) {
        Setor setor = mapper.map(body, Setor.class);
        validation.validaSetor(setor);
        Setor setorResponse = this.setorRepository.save(setor);
        return mapper.map(setorResponse, SetorDto.class);
    }

    @Override
	public List<SetorDto> listar() {
		List<SetorDto> setores = new ArrayList<>();
		setores = this.setorRepository.findAll().stream().map(c -> mapper.map(c, SetorDto.class))
					.collect(Collectors.toList());
		return setores;
	}

    @Override
    public SetorDto procurar(Long id) {
        Optional<Setor> setor = this.setorRepository.findById(id);
        if (setor.isPresent() == true) {
            return mapper.map(setor.get(), SetorDto.class);
        }
        throw new RuntimeException("Setor não encontrado");
    }

    @Override
    public SetorDto atualizar(Long id, SetorFormDto body) {
        Optional<Setor> setor = this.setorRepository.findById(id);
        if (setor.isPresent() == true) {
            setor.get().setNome(body.getNome());
            Setor st = this.setorRepository.save(setor.get());
            return mapper.map(st, SetorDto.class);
        }
        throw new RuntimeException("Setor não encontrado");
    }


    @Override
    public void remover(Long id) {
    	Optional<Setor> setor = this.setorRepository.findById(id);
		if (setor.isPresent() == true) {
			this.setorRepository.deleteById(id);
		} else {
			throw new RuntimeException("Setor não encontrado");
		}
    }
}