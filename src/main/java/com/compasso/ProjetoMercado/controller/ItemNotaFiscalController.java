package com.compasso.ProjetoMercado.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.ProjetoMercado.dto.ItemNotaFiscalDto;
import com.compasso.ProjetoMercado.service.ItemNotaFiscalService;

@RestController
@RequestMapping("/itensNotaFiscal")
public class ItemNotaFiscalController {

	@Autowired
	private ItemNotaFiscalService itemNotaFiscalService;
	
	@GetMapping
	public ResponseEntity<List<ItemNotaFiscalDto>> listar() {
		return ResponseEntity.ok(this.itemNotaFiscalService.listar());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemNotaFiscalDto> procurar(@PathVariable Long id) {
		return ResponseEntity.ok(this.itemNotaFiscalService.procurar(id));
	}
	
}