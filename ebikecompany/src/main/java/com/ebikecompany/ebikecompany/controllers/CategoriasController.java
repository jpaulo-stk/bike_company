package com.ebikecompany.ebikecompany.controllers;

import com.ebikecompany.ebikecompany.Errors.ErrorValidate;
import com.ebikecompany.ebikecompany.dtos.CategoriasRequestDTO;
import com.ebikecompany.ebikecompany.models.CategoriasEntity;
import com.ebikecompany.ebikecompany.repository.CategoriasRepository;
import com.ebikecompany.ebikecompany.service.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
public class CategoriasController  {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public ResponseEntity<List<CategoriasEntity>> lerCategorias() {
        try{
            List<CategoriasEntity> categorias = this.categoriasService.lerCategorias();
            return ResponseEntity.ok(categorias);
        } catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriasEntity> LerCategoriasPorId(@PathVariable Integer id) {
        try{
            CategoriasEntity categorias = this.categoriasService.lerCategoriasPorId(id);
            return ResponseEntity.ok(categorias);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/criar")
    public ResponseEntity<CategoriasEntity> salvarCategoria(@RequestBody CategoriasRequestDTO dto) {
        try {
            CategoriasEntity categorias = this.categoriasService.criarCategoria(dto);
            return ResponseEntity.ok(categorias);
        } catch (IllegalArgumentException e) {
            if(e instanceof ErrorValidate){
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategorias(@PathVariable Integer id) {
        try {
            this.categoriasService.deletarCategoria(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e ){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriasEntity> atualizarCategoria(@PathVariable Integer id, @RequestBody CategoriasRequestDTO dto) {
        try {
            CategoriasEntity categorias = this.categoriasService.atualizarCategoria(id, dto);
            return ResponseEntity.ok(categorias);
        } catch (IllegalArgumentException e){
        if(e instanceof ErrorValidate){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.notFound().build();
        }
    }
}
