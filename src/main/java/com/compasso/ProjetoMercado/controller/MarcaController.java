package com.compasso.ProjetoMercado.controller;


import com.compasso.ProjetoMercado.dto.MarcaDTO;
import com.compasso.ProjetoMercado.dto.MarcaFormDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/Marca")
public class MarcaController {

    private com.compasso.ProjetoMercado.service.MarcaService MarcaService;

    @PostMapping
    @Transactional
    public ResponseEntity<MarcaDTO> salvar(@RequestBody MarcaFormDTO body) {
        return ResponseEntity.ok(this.MarcaService.salvar(body));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaDTO> consultar(@PathVariable Long id) {
        return ResponseEntity.ok(this.MarcaService.consultar(id));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<MarcaDTO> atualizar(@PathVariable Long id, @RequestBody @Valid MarcaFormDTO body) {
        return ResponseEntity.ok(this.MarcaService.atualizar(id, body));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        this.MarcaService.excluir(id);
        return ResponseEntity.ok().build();
    }

}
