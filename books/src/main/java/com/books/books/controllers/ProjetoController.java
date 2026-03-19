package com.books.books.controllers;

import com.books.books.models.ProjetoModel;
import com.books.books.services.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/projeto")
public class ProjetoController {
    @Autowired
    private ProjetoService projetoService;

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> findAll() {
        List<ProjetoModel> projetos = projetoService.findAll();
        return ResponseEntity.status(200).body(projetos);
    }

    @PostMapping
    public ResponseEntity<ProjetoModel> criarProjeto(@RequestBody ProjetoModel projetoModel) {
        ProjetoModel projeto = projetoService.criarProjeto(projetoModel);
        return ResponseEntity.status(201).body(projeto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProjetoModel>> findById(@PathVariable Long id) {
        Optional<ProjetoModel> projeto = projetoService.findById(id);
        return ResponseEntity.status(200).body(projeto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoModel> atualizarProjeto(@PathVariable Long id, @RequestBody ProjetoModel projetoModel) {
        ProjetoModel projeto = projetoService.findById(id).get();
        projeto.setNome(projetoModel.getNome());
        return ResponseEntity.status(200).body(projeto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProjeto(@PathVariable Long id) {
        projetoService.deletarProjeto(id);
        return ResponseEntity.status(204).build();
    }
}
