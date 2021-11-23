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

import com.compasso.ProjetoMercado.dto.CaixaDto;
import com.compasso.ProjetoMercado.dto.CaixaFormDto;
import com.compasso.ProjetoMercado.service.CaixaService;

@RestController
@RequestMapping("/caixas")
public class CaixaController {

	@Autowired
	private CaixaService caixaService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CaixaDto> salvar(@RequestBody CaixaFormDto body) {
		return ResponseEntity.ok(this.caixaService.salvar(body));
	}
	
	@GetMapping
	public ResponseEntity<List<CaixaDto>> listar() {
		return ResponseEntity.ok(this.caixaService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CaixaDto> procurar(@PathVariable Long id) {
		return ResponseEntity.ok(this.caixaService.procurar(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CaixaDto> atualizar(@PathVariable Long id, @RequestBody @Valid CaixaFormDto body) {
		return ResponseEntity.ok(this.caixaService.atualizar(id, body));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		this.caixaService.remover(id);
		return ResponseEntity.ok().build();
	}
}
