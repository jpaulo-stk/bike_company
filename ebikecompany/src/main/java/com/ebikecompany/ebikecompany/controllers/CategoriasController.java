package com.ebikecompany.ebikecompany.controllers;

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
public class CategoriasController   {

    @Autowired
    private CategoriasRepository categoriasRepository;

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping
    public ResponseEntity<List<CategoriasEntity>> lerCategorias() {
        List<CategoriasEntity> categorias = this.categoriasService.lerCategorias().getBody();
        return  ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriasEntity> LerCategoriasPorId(@PathVariable Integer id) {
        CategoriasEntity categorias = this.categoriasService.lerCategoriasPorId(id).getBody();
        return ResponseEntity.ok(categorias);
    }


    @PostMapping("/criar")
    public ResponseEntity<CategoriasEntity> save(@RequestBody CategoriasRequestDTO dto) {
        CategoriasEntity categorias = this.categoriasService.criarCategoria(dto).getBody();
        return  ResponseEntity.ok(categorias);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.categoriasService.deletarCategoria(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriasEntity> update(@PathVariable Integer id, @RequestBody CategoriasRequestDTO dto) {
       CategoriasEntity categorias = this.categoriasService.atualizarCategoria(id,dto).getBody();
        return ResponseEntity.ok(categorias);
    }
}
