package com.compasso.ProjetoMercado.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.ProjetoMercado.dto.NotaFiscalDto;
import com.compasso.ProjetoMercado.dto.NotaFiscalFormDto;
import com.compasso.ProjetoMercado.service.NotaFiscalService;

@RestController
@RequestMapping("/notasFiscais")
public class NotaFiscalController {

	@Autowired
	private NotaFiscalService notaFiscalService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<NotaFiscalDto> salvar(@RequestBody NotaFiscalFormDto body) {
		return ResponseEntity.ok(this.notaFiscalService.salvar(body));
	}
	
	@GetMapping
	public ResponseEntity<List<NotaFiscalDto>> listar() {
		return ResponseEntity.ok(this.notaFiscalService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<NotaFiscalDto> procurar(@PathVariable Long id) {
		return ResponseEntity.ok(this.notaFiscalService.procurar(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<NotaFiscalDto> atualizar(@PathVariable Long id, @RequestBody @Valid NotaFiscalFormDto body) {
		return ResponseEntity.ok(this.notaFiscalService.atualizar(id, body));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		this.notaFiscalService.remover(id);
		return ResponseEntity.ok().build();
	}
}
