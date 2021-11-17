package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.FuncionarioDto;
import com.compasso.ProjetoMercado.dto.FuncionarioFormDto;
import com.compasso.ProjetoMercado.entity.Funcionario;
import com.compasso.ProjetoMercado.repository.FuncionarioRepository;
import com.compasso.ProjetoMercado.validation.Validation;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private Validation validation;

	@Override
	public FuncionarioDto salvar(FuncionarioFormDto body) {
		Funcionario funcionario = mapper.map(body, Funcionario.class);
		validation.validaFuncionario(funcionario);
		Funcionario funcionarioResponse = this.funcionarioRepository.save(funcionario);
		return mapper.map(funcionarioResponse, FuncionarioDto.class);
	}

	@Override
	public List<FuncionarioDto> listar() {
		List<FuncionarioDto> funcionarios = new ArrayList<>();
		funcionarios = this.funcionarioRepository.findAll().stream().map(f -> mapper.map(f, FuncionarioDto.class))
					.collect(Collectors.toList());
		return funcionarios;
	}

	@Override
	public FuncionarioDto procurar(Long id) {
		Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);
		if (funcionario.isPresent() == true) {
			return mapper.map(funcionario.get(), FuncionarioDto.class);
		}
		throw new RuntimeException("Funcionario não encontrado");
	}

	@Override
	public FuncionarioDto atualizar(Long id, FuncionarioFormDto body) {
		Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);
		if (funcionario.isPresent() == true) {
			funcionario.get().setCpf(body.getCpf());
			funcionario.get().setNome(body.getNome());
			funcionario.get().setDataNascimento(body.getDataNascimento());
			funcionario.get().setSexo(body.getSexo());
			Funcionario f = this.funcionarioRepository.save(funcionario.get());
			return mapper.map(f, FuncionarioDto.class);
		}
		throw new RuntimeException("Funcionario não encontrado");
	}

	@Override
	public void remover(Long id) {
		Optional<Funcionario> funcionario = this.funcionarioRepository.findById(id);
		if (funcionario.isPresent() == true) {
			this.funcionarioRepository.deleteById(id);
		} else {
			throw new RuntimeException("Funcionario não encontrado");
		}
	}
}
