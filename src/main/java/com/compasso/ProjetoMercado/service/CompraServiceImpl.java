package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.CompraDto;
import com.compasso.ProjetoMercado.dto.CompraFormDto;
import com.compasso.ProjetoMercado.entity.Compra;
import com.compasso.ProjetoMercado.repository.CompraRepository;
import com.compasso.ProjetoMercado.validation.DadosNulosValidation;

@Service
public class CompraServiceImpl implements CompraService {
	
	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private DadosNulosValidation validation;

	@Override
	public CompraDto salvar(CompraFormDto body) {
		Compra compra = mapper.map(body, Compra.class);
		validation.validaCompra(compra);
		Compra compraResponse = this.compraRepository.save(compra);
		return mapper.map(compraResponse, CompraDto.class);
	}

	@Override
	public List<CompraDto> listar() {
		List<CompraDto> compras = new ArrayList<>();
		compras = this.compraRepository.findAll().stream().map(c -> mapper.map(c, CompraDto.class))
					.collect(Collectors.toList());
		return compras;
	}

	@Override
	public CompraDto procurar(Long id) {
		Optional<Compra> compra = this.compraRepository.findById(id);
		if (compra.isPresent() == true) {
			return mapper.map(compra.get(), CompraDto.class);
		}
		throw new RuntimeException("Compra não encontrada");
	}

	@Override
	public CompraDto atualizar(Long id, CompraFormDto body) {
		Optional<Compra> compra = this.compraRepository.findById(id);
		if (compra.isPresent() == true) {
			compra.get().setDataHora(body.getDataHora());
			compra.get().setCliente(body.getCliente());
			compra.get().setCaixa(body.getCaixa());
			Compra c = this.compraRepository.save(compra.get());
			return mapper.map(c, CompraDto.class);
		}
		throw new RuntimeException("Compra não encontrada");
	}

	@Override
	public void remover(Long id) {
		Optional<Compra> compra = this.compraRepository.findById(id);
		if (compra.isPresent() == true) {
			this.compraRepository.deleteById(id);
		} else {
			throw new RuntimeException("Compra não encontrada");
		}
	}
}
