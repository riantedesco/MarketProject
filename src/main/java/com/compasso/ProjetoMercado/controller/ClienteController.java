package com.compasso.ProjetoMercado.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import com.compasso.ProjetoMercado.dto.ClienteDto;
import com.compasso.ProjetoMercado.dto.ClienteFormDto;
import com.compasso.ProjetoMercado.service.ClienteService;
import com.compasso.ProjetoMercado.entity.Cliente;

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

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();

			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
