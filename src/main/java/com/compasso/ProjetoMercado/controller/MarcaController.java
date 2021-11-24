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

import com.compasso.ProjetoMercado.dto.MarcaDto;
import com.compasso.ProjetoMercado.dto.MarcaFormDto;
import com.compasso.ProjetoMercado.service.MarcaService;


@RestController
@RequestMapping("/marcas")
public class MarcaController {
    
	@Autowired
	private MarcaService marcaService;

	@PostMapping
	@Transactional
	public ResponseEntity<MarcaDto> salvar(@RequestBody @Valid MarcaFormDto body) {
		return ResponseEntity.ok(this.marcaService.salvar(body));
	}
	
	@GetMapping
	public ResponseEntity<List<MarcaDto>> listar() {
		return ResponseEntity.ok(this.marcaService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MarcaDto> procurar(@PathVariable Long id) {
		return ResponseEntity.ok(this.marcaService.procurar(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<MarcaDto> atualizar(@PathVariable Long id, @RequestBody @Valid MarcaFormDto body) {
		return ResponseEntity.ok(this.marcaService.atualizar(id, body));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		this.marcaService.remover(id);
		return ResponseEntity.ok().build();
	}
}
