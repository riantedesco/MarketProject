package com.compasso.ProjetoMercado.controller;


import com.compasso.ProjetoMercado.dto.SetorDTO;
import com.compasso.ProjetoMercado.dto.SetorFormDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/Setor")
public class SetorController {

    private com.compasso.ProjetoMercado.service.SetorService SetorService;

    @PostMapping
    @Transactional
    public ResponseEntity<SetorDTO> salvar(@RequestBody SetorFormDTO body) {
        return ResponseEntity.ok(this.SetorService.salvar(body));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SetorDTO> consultar(@PathVariable Long id) {
        return ResponseEntity.ok(this.SetorService.consultar(id));
    }


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<Optional> atualizar(@PathVariable Long id, @RequestBody @Valid SetorFormDTO body) {
        return ResponseEntity.ok(this.SetorService.atualizar(id, body));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> excluir(@PathVariable Long id) {
        this.SetorService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
