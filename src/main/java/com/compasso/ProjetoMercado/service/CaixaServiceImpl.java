package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.CaixaDto;
import com.compasso.ProjetoMercado.dto.CaixaFormDto;
import com.compasso.ProjetoMercado.entity.Caixa;
import com.compasso.ProjetoMercado.repository.CaixaRepository;
import com.compasso.ProjetoMercado.validation.Validation;

@Service
public class CaixaServiceImpl implements CaixaService {
	
	@Autowired
	private CaixaRepository caixaRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private Validation validation;

	@Override
	public CaixaDto salvar(CaixaFormDto body) {
		Caixa caixa = mapper.map(body, Caixa.class);
		validation.validaCaixa(caixa);
		Caixa caixaResponse = this.caixaRepository.save(caixa);
		return mapper.map(caixaResponse, CaixaDto.class);
	}

	@Override
	public List<CaixaDto> listar() {
		List<CaixaDto> caixas = new ArrayList<>();
		caixas = this.caixaRepository.findAll().stream().map(c -> mapper.map(c, CaixaDto.class))
					.collect(Collectors.toList());
		return caixas;
	}

	@Override
	public CaixaDto procurar(Long id) {
		Optional<Caixa> caixa = this.caixaRepository.findById(id);
		if (caixa.isPresent() == true) {
			return mapper.map(caixa.get(), CaixaDto.class);
		}
		throw new RuntimeException("Cliente não encontrado");
	}

	@Override
	public CaixaDto atualizar(Long id, CaixaFormDto body) {
		Optional<Caixa> caixa = this.caixaRepository.findById(id);
		if (caixa.isPresent() == true) {
			caixa.get().setAtivo(body.getAtivo());
			caixa.get().setFuncionario(body.getFuncionario());
			Caixa c = this.caixaRepository.save(caixa.get());
			return mapper.map(c, CaixaDto.class);
		}
		throw new RuntimeException("Cliente não encontrado");
	}

	@Override
	public void remover(Long id) {
		Optional<Caixa> caixa = this.caixaRepository.findById(id);
		if (caixa.isPresent() == true) {
			this.caixaRepository.deleteById(id);
		} else {
			throw new RuntimeException("Cliente não encontrado");
		}
	}
}
