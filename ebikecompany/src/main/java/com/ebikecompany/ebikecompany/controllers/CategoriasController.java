package com.ebikecompany.ebikecompany.controllers;

import com.ebikecompany.ebikecompany.dtos.CategoriasRequestDTO;
import com.ebikecompany.ebikecompany.models.CategoriasEntity;
import com.ebikecompany.ebikecompany.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")

interface useCase {
    ResponseEntity<List<CategoriasEntity>> findall();
    CategoriasEntity findById(@PathVariable Integer id);
    ResponseEntity<CategoriasEntity> save(CategoriasRequestDTO dto);
    ResponseEntity<CategoriasEntity> update(@PathVariable Integer id, @RequestBody CategoriasRequestDTO dto);
    ResponseEntity<Void> delete(@PathVariable Integer id);
}

public class CategoriasController implements  useCase  {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @GetMapping
    public ResponseEntity<List<CategoriasEntity>> findall() {
        List<CategoriasEntity> categorias = this.categoriasRepository.findAll();
        return  ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public CategoriasEntity findById(@PathVariable Integer id) {
        return  this.categoriasRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("Categoria nao encontrada"));

    }

    @PostMapping
    public ResponseEntity<CategoriasEntity> save(@RequestBody CategoriasRequestDTO dto) {
        if(dto.name().isEmpty()){
            return ResponseEntity.status(400).build();
        }
        CategoriasEntity category = new CategoriasEntity();
        category.setNome(dto.name());
        this.categoriasRepository.save(category);
        return ResponseEntity.ok(category);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        CategoriasEntity category = this.categoriasRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não foi encontrada"));

        this.categoriasRepository.delete(category);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriasEntity> update(@PathVariable Integer id, @RequestBody CategoriasRequestDTO dto) {
        if (dto.name().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        CategoriasEntity category = this.categoriasRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Categoria não foi encontrada"));

        category.setNome(dto.name());

        this.categoriasRepository.save(category);
        return ResponseEntity.ok(category);
    }
}
