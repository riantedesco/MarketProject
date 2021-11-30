package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.AssociaFuncionarioFormDto;
import com.compasso.ProjetoMercado.dto.CaixaDto;
import com.compasso.ProjetoMercado.dto.CaixaFormDto;
import com.compasso.ProjetoMercado.dto.DesassociaFuncionarioFormDto;
import com.compasso.ProjetoMercado.entity.Caixa;
import com.compasso.ProjetoMercado.entity.Funcionario;
import com.compasso.ProjetoMercado.repository.CaixaRepository;
import com.compasso.ProjetoMercado.repository.FuncionarioRepository;
import com.compasso.ProjetoMercado.validation.DadosNulosValidation;

@Service
public class CaixaServiceImpl implements CaixaService {
	
	@Autowired
	private CaixaRepository caixaRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private DadosNulosValidation validation;

	@Override
	public CaixaDto salvar(CaixaFormDto body) {
		Caixa caixa = mapper.map(body, Caixa.class);
		validation.validaCaixa(caixa);
		Caixa caixaResponse = this.caixaRepository.save(caixa);
		return mapper.map(caixaResponse, CaixaDto.class);
	}
	
	@Override
	public CaixaDto associarFuncionario(AssociaFuncionarioFormDto body) {
		Optional<Caixa> caixa = this.caixaRepository.findById(body.getIdCaixa());
		Optional<Funcionario> funcionario = this.funcionarioRepository.findById(body.getIdFuncionario());
		if (caixa.isPresent() && funcionario.isPresent() == true) {
			caixa.get().setFuncionario(funcionario.get());
			caixa.get().setAtivo(true);
			Caixa c = this.caixaRepository.save(caixa.get());
			return mapper.map(c, CaixaDto.class);
		}
		throw new RuntimeException("Caixa não encontrado");
	}
	
	@Override
	public CaixaDto desassociarFuncionario(DesassociaFuncionarioFormDto body) {
		Optional<Caixa> caixa = this.caixaRepository.findById(body.getIdCaixa());
		if (caixa.isPresent() == true) {
			caixa.get().setFuncionario(null);
			caixa.get().setAtivo(false);
			Caixa c = this.caixaRepository.save(caixa.get());
			return mapper.map(c, CaixaDto.class);
		}
		throw new RuntimeException("Caixa não encontrado");
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
		throw new RuntimeException("Caixa não encontrado");
	}

	@Override
	public CaixaDto atualizar(Long id, CaixaFormDto body) {
		Optional<Caixa> caixa = this.caixaRepository.findById(id);
		if (caixa.isPresent() == true) {
			caixa.get().setDescricao(body.getDescricao());
			caixa.get().setSenha(body.getSenha());
			Caixa c = this.caixaRepository.save(caixa.get());
			return mapper.map(c, CaixaDto.class);
		}
		throw new RuntimeException("Caixa não encontrado");
	}

	@Override
	public void remover(Long id) {
		Optional<Caixa> caixa = this.caixaRepository.findById(id);
		if (caixa.isPresent() == true) {
			this.caixaRepository.deleteById(id);
		} else {
			throw new RuntimeException("Caixa não encontrado");
		}
	}
}
