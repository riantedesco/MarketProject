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

import com.compasso.ProjetoMercado.dto.SetorDto;
import com.compasso.ProjetoMercado.dto.SetorFormDto;
import com.compasso.ProjetoMercado.service.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorController {

	@Autowired
	private SetorService setorService;

	@PostMapping
	@Transactional
	public ResponseEntity<SetorDto> salvar(@RequestBody @Valid SetorFormDto body) {
		return ResponseEntity.ok(this.setorService.salvar(body));
	}
	
	@GetMapping
	public ResponseEntity<List<SetorDto>> listar() {
		return ResponseEntity.ok(this.setorService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SetorDto> procurar(@PathVariable Long id) {
		return ResponseEntity.ok(this.setorService.procurar(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<SetorDto> atualizar(@PathVariable Long id, @RequestBody @Valid SetorFormDto body) {
		return ResponseEntity.ok(this.setorService.atualizar(id, body));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		this.setorService.remover(id);
		return ResponseEntity.ok().build();
	}
}