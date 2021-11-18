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

import com.compasso.ProjetoMercado.dto.ItemCompraDto;
import com.compasso.ProjetoMercado.dto.ItemCompraFormDto;
import com.compasso.ProjetoMercado.service.ItemCompraService;

@RestController
@RequestMapping("/itensCompra")
public class ItemCompraController {

	@Autowired
	private ItemCompraService itemCompraService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ItemCompraDto> salvar(@RequestBody ItemCompraFormDto body) {
		return ResponseEntity.ok(this.itemCompraService.salvar(body));
	}
	
	@GetMapping
	public ResponseEntity<List<ItemCompraDto>> listar() {
		return ResponseEntity.ok(this.itemCompraService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemCompraDto> procurar(@PathVariable Long id) {
		return ResponseEntity.ok(this.itemCompraService.procurar(id));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ItemCompraDto> atualizar(@PathVariable Long id, @RequestBody @Valid ItemCompraFormDto body) {
		return ResponseEntity.ok(this.itemCompraService.atualizar(id, body));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		this.itemCompraService.remover(id);
		return ResponseEntity.ok().build();
	}
}
