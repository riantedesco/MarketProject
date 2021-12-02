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

import com.compasso.ProjetoMercado.dto.FuncionarioDto;
import com.compasso.ProjetoMercado.dto.FuncionarioFormDto;
import com.compasso.ProjetoMercado.service.FuncionarioService;
import com.compasso.ProjetoMercado.entity.Funcionario;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<FuncionarioDto> salvar(@RequestBody @Valid FuncionarioFormDto body) {
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
