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

import com.compasso.ProjetoMercado.dto.ProdutosDto;
import com.compasso.ProjetoMercado.dto.ProdutosFormDto;
import com.compasso.ProjetoMercado.service.ProdutosService;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

	@Autowired
	private ProdutosService produtosService;

	@PostMapping
	@Transactional
	public ResponseEntity<ProdutosDto> salvar(@RequestBody @Valid ProdutosFormDto body) {
		return ResponseEntity.ok(this.produtosService.salvar(body));
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutosDto>> listar() {
		return ResponseEntity.ok(this.produtosService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutosDto> procurar(@PathVariable Long id) {
		return ResponseEntity.ok(this.produtosService.procurar(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProdutosDto> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutosFormDto body) {
		return ResponseEntity.ok(this.produtosService.atualizar(id, body));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		this.produtosService.remover(id);
		return ResponseEntity.ok().build();
	}
}
