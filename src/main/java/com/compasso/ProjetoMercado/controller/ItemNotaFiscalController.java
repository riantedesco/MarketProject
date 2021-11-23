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

import com.compasso.ProjetoMercado.dto.ItemNotaFiscalDto;
import com.compasso.ProjetoMercado.dto.ItemNotaFiscalFormDto;
import com.compasso.ProjetoMercado.service.ItemNotaFiscalService;

@RestController
@RequestMapping("/itensNotaFiscal")
public class ItemNotaFiscalController {

	@Autowired
	private ItemNotaFiscalService itemNotaFiscalService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ItemNotaFiscalDto> salvar(@RequestBody @Valid ItemNotaFiscalFormDto body) {
		return ResponseEntity.ok(this.itemNotaFiscalService.salvar(body));
	}
	
	@GetMapping
	public ResponseEntity<List<ItemNotaFiscalDto>> listar() {
		return ResponseEntity.ok(this.itemNotaFiscalService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemNotaFiscalDto> procurar(@PathVariable Long id) {
		return ResponseEntity.ok(this.itemNotaFiscalService.procurar(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ItemNotaFiscalDto> atualizar(@PathVariable Long id, @RequestBody @Valid ItemNotaFiscalFormDto body) {
		return ResponseEntity.ok(this.itemNotaFiscalService.atualizar(id, body));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		this.itemNotaFiscalService.remover(id);
		return ResponseEntity.ok().build();
	}
}
