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

import com.compasso.ProjetoMercado.dto.CompraDto;
import com.compasso.ProjetoMercado.dto.CompraFormDto;
import com.compasso.ProjetoMercado.service.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {

	@Autowired
	private CompraService compraService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<CompraDto> salvar(@RequestBody @Valid CompraFormDto body) {
		return ResponseEntity.ok(this.compraService.salvar(body));
	}
	
	@GetMapping
	public ResponseEntity<List<CompraDto>> listar() {
		return ResponseEntity.ok(this.compraService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CompraDto> procurar(@PathVariable Long id) {
		return ResponseEntity.ok(this.compraService.procurar(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<CompraDto> atualizar(@PathVariable Long id, @RequestBody @Valid CompraFormDto body) {
		return ResponseEntity.ok(this.compraService.atualizar(id, body));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		this.compraService.remover(id);
		return ResponseEntity.ok().build();
	}
}
