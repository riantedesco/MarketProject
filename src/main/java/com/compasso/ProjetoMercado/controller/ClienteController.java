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

import com.compasso.ProjetoMercado.dto.ClienteDto;
import com.compasso.ProjetoMercado.dto.ClienteFormDto;
import com.compasso.ProjetoMercado.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> salvar(@RequestBody @Valid ClienteFormDto body) {
		return ResponseEntity.ok(this.clienteService.salvar(body));
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteDto>> listar() {
		return ResponseEntity.ok(this.clienteService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> procurar(@PathVariable Long id) {
		return ResponseEntity.ok(this.clienteService.procurar(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> atualizar(@PathVariable Long id, @RequestBody @Valid ClienteFormDto body) {
		return ResponseEntity.ok(this.clienteService.atualizar(id, body));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		this.clienteService.remover(id);
		return ResponseEntity.ok().build();
	}
}
