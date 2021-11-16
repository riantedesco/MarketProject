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

import com.compasso.ProjetoMercado.dto.FuncionarioDto;
import com.compasso.ProjetoMercado.dto.FuncionarioFormDto;
import com.compasso.ProjetoMercado.service.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<FuncionarioDto> salvar(@RequestBody FuncionarioFormDto body) {
		return ResponseEntity.ok(this.funcionarioService.salvar(body));
	}
	
	@GetMapping
	public ResponseEntity<List<FuncionarioDto>> listar() {
		return ResponseEntity.ok(this.funcionarioService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FuncionarioDto> procurar(@PathVariable Long id) {
		return ResponseEntity.ok(this.funcionarioService.procurar(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<FuncionarioDto> atualizar(@PathVariable Long id, @RequestBody @Valid FuncionarioFormDto body) {
		return ResponseEntity.ok(this.funcionarioService.atualizar(id, body));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		this.funcionarioService.remover(id);
		return ResponseEntity.ok().build();
	}
}
