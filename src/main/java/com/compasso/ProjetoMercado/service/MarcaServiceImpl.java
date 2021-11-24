package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.MarcaDto;
import com.compasso.ProjetoMercado.dto.MarcaFormDto;
import com.compasso.ProjetoMercado.entity.Marca;
import com.compasso.ProjetoMercado.repository.MarcaRepository;
import com.compasso.ProjetoMercado.validation.DadosNulosValidation;

@Service
public class MarcaServiceImpl implements MarcaService {

	@Autowired
	private MarcaRepository marcaRepository;
	
    @Autowired
    private ModelMapper mapper;
    
    @Autowired
	private DadosNulosValidation validation;
    
    @Override
    public MarcaDto salvar(MarcaFormDto body) {
        Marca marca = mapper.map(body, Marca.class);
        validation.validaMarca(marca);
        Marca marcaResponse = this.marcaRepository.save(marca);
        return mapper.map(marcaResponse, MarcaDto.class);
    }
    
    @Override
	public List<MarcaDto> listar() {
		List<MarcaDto> marcas = new ArrayList<>();
		marcas = this.marcaRepository.findAll().stream().map(c -> mapper.map(c, MarcaDto.class))
					.collect(Collectors.toList());
		return marcas;
	}

    @Override
    public MarcaDto procurar(Long id) {
        Optional<Marca> marca = this.marcaRepository.findById(id);
        if (marca.isPresent() == true) {
        	return mapper.map(marca.get(), MarcaDto.class);
        }
        throw new RuntimeException("Marca não encontrada");
    }


    @Override
    public MarcaDto atualizar(Long id, MarcaFormDto body) {
        Optional<Marca> marca = this.marcaRepository.findById(id);
        if (marca.isPresent() == true) {
            marca.get().setNome(body.getNome());
            marca.get().setTipoMercadoria(body.getTipoMercadoria());
            Marca mc = this.marcaRepository.save(marca.get());
            return mapper.map(mc, MarcaDto.class);
        }
        throw new RuntimeException("Marca não encontrada");
    }

    @Override
    public void remover(Long id) {
    	Optional<Marca> marca = this.marcaRepository.findById(id);
		if (marca.isPresent() == true) {
			this.marcaRepository.deleteById(id);
		} else {
			throw new RuntimeException("Marca não encontrada");
		}
    }
}