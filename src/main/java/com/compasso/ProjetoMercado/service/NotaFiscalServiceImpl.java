package com.compasso.ProjetoMercado.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compasso.ProjetoMercado.dto.NotaFiscalDto;
import com.compasso.ProjetoMercado.dto.NotaFiscalFormDto;
import com.compasso.ProjetoMercado.entity.NotaFiscal;
import com.compasso.ProjetoMercado.repository.NotaFiscalRepository;
import com.compasso.ProjetoMercado.validation.Validation;

@Service
public class NotaFiscalServiceImpl implements NotaFiscalService {
	
	@Autowired
	private NotaFiscalRepository notaFiscalRepository;

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private Validation validation;

	@Override
	public NotaFiscalDto salvar(NotaFiscalFormDto body) {
		NotaFiscal notaFiscal = mapper.map(body, NotaFiscal.class);
		validation.validaNotaFiscal(notaFiscal);
		NotaFiscal notaFiscalResponse = this.notaFiscalRepository.save(notaFiscal);
		return mapper.map(notaFiscalResponse, NotaFiscalDto.class);
	}

	@Override
	public List<NotaFiscalDto> listar() {
		List<NotaFiscalDto> notasFiscais = new ArrayList<>();
		notasFiscais = this.notaFiscalRepository.findAll().stream().map(nf -> mapper.map(nf, NotaFiscalDto.class))
					.collect(Collectors.toList());
		return notasFiscais;
	}

	@Override
	public NotaFiscalDto procurar(Long id) {
		Optional<NotaFiscal> notaFiscal = this.notaFiscalRepository.findById(id);
		if (notaFiscal.isPresent() == true) {
			return mapper.map(notaFiscal.get(), NotaFiscalDto.class);
		}
		throw new RuntimeException("Nota fiscal não encontrada");
	}

	@Override
	public NotaFiscalDto atualizar(Long id, NotaFiscalFormDto body) {
		Optional<NotaFiscal> notaFiscal = this.notaFiscalRepository.findById(id);
		if (notaFiscal.isPresent() == true) {
			notaFiscal.get().setNumero(body.getNumero());
			notaFiscal.get().setDataHoraEntrada(body.getDataHoraEntrada());
			NotaFiscal nf = this.notaFiscalRepository.save(notaFiscal.get());
			return mapper.map(nf, NotaFiscalDto.class);
		}
		throw new RuntimeException("Nota fiscal não encontrada");
	}

	@Override
	public void remover(Long id) {
		Optional<NotaFiscal> notaFiscal = this.notaFiscalRepository.findById(id);
		if (notaFiscal.isPresent() == true) {
			this.notaFiscalRepository.deleteById(id);
		} else {
			throw new RuntimeException("Nota fiscal não encontrada");
		}
	}
}
