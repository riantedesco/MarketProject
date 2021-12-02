package com.compasso.ProjetoMercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.ProjetoMercado.dto.ItemCompraDto;
import com.compasso.ProjetoMercado.service.ItemCompraService;

@RestController
@RequestMapping("/itensCompra")
public class ItemCompraController {

	@Autowired
	private ItemCompraService itemCompraService;
	
	@GetMapping
	public ResponseEntity<List<ItemCompraDto>> listar() {
		return ResponseEntity.ok(this.itemCompraService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemCompraDto> procurar(@PathVariable Long id) {
		return ResponseEntity.ok(this.itemCompraService.procurar(id));
	}
	
}
