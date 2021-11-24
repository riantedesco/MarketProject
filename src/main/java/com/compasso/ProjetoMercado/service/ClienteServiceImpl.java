package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.ClienteDto;
import com.compasso.ProjetoMercado.dto.ClienteFormDto;
import com.compasso.ProjetoMercado.entity.Cliente;
import com.compasso.ProjetoMercado.repository.ClienteRepository;
import com.compasso.ProjetoMercado.validation.DadosNulosValidation;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private DadosNulosValidation validation;

	@Override
	public ClienteDto salvar(ClienteFormDto body) {
		Cliente cliente = mapper.map(body, Cliente.class);
		validation.validaCliente(cliente);
		Cliente clienteResponse = this.clienteRepository.save(cliente);
		return mapper.map(clienteResponse, ClienteDto.class);
	}

	@Override
	public List<ClienteDto> listar() {
		List<ClienteDto> clientes = new ArrayList<>();
		clientes = this.clienteRepository.findAll().stream().map(c -> mapper.map(c, ClienteDto.class))
					.collect(Collectors.toList());
		return clientes;
	}

	@Override
	public ClienteDto procurar(Long id) {
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		if (cliente.isPresent() == true) {
			return mapper.map(cliente.get(), ClienteDto.class);
		}
		throw new RuntimeException("Cliente não encontrado");
	}

	@Override
	public ClienteDto atualizar(Long id, ClienteFormDto body) {
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		if (cliente.isPresent() == true) {
			cliente.get().setCpf(body.getCpf());
			cliente.get().setNome(body.getNome());
			cliente.get().setDataNascimento(body.getDataNascimento());
			cliente.get().setSexo(body.getSexo());
			Cliente c = this.clienteRepository.save(cliente.get());
			return mapper.map(c, ClienteDto.class);
		}
		throw new RuntimeException("Cliente não encontrado");
	}

	@Override
	public void remover(Long id) {
		Optional<Cliente> cliente = this.clienteRepository.findById(id);
		if (cliente.isPresent() == true) {
			this.clienteRepository.deleteById(id);
		} else {
			throw new RuntimeException("Cliente não encontrado");
		}
	}
}
