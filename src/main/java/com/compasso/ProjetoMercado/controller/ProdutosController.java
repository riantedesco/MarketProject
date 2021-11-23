package com.compasso.ProjetoMercado.controller;


import com.compasso.ProjetoMercado.dto.ProdutosDTO;
import com.compasso.ProjetoMercado.dto.ProdutosFormDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/Produtos")
public class ProdutosController {

    private com.compasso.ProjetoMercado.service.ProdutosService ProdutosService;

    @PostMapping
    @Transactional
    public ResponseEntity<ProdutosDTO> salvar(@RequestBody @Valid  ProdutosFormDTO body) {
        return ResponseEntity.ok(this.ProdutosService.salvar(body));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosDTO> consultar(@PathVariable Long id) {
        return ResponseEntity.ok(this.ProdutosService.consultar(id));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProdutosDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutosFormDTO body) {
        return ResponseEntity.ok(this.ProdutosService.atualizar(id, body));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        this.ProdutosService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
