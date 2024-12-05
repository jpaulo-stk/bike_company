package com.ebikecompany.ebikecompany.controllers;

import com.ebikecompany.ebikecompany.Errors.ErrorValidate;
import com.ebikecompany.ebikecompany.dtos.MarcaDTO;
import com.ebikecompany.ebikecompany.models.MarcaEntity;
import com.ebikecompany.ebikecompany.repository.MarcaRepository;
import com.ebikecompany.ebikecompany.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/marcas")
public class MarcaController {

    @Autowired
    private MarcaRepository repository;

    @Autowired
    private MarcaService marcaService;

    @GetMapping
    public ResponseEntity<List<MarcaEntity>> pegarTodasAsMarcas() {
        List<MarcaEntity> marcas = this.marcaService.pegarTodasMarcas();
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaEntity> pegarMarcaPeloId(@PathVariable Integer id) {
        try {
            MarcaEntity marca = this.marcaService.pegarMarcaPeloId(id);
            return ResponseEntity.ok(marca);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<MarcaEntity> criarMarca(@RequestBody MarcaDTO dto) {
        try {
            MarcaEntity marca = this.marcaService.criarMarca(dto);
            return ResponseEntity.ok(marca);
        } catch (IllegalArgumentException e) {
            if (e instanceof ErrorValidate) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMarcaPeloId(@PathVariable Integer id) {
        try {
            this.marcaService.deletarMarca(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException error) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaEntity> atualizarMarcaPeloId(@PathVariable Integer id, @RequestBody MarcaDTO dto) {
        try {
            MarcaEntity marca = this.marcaService.atualizarMarca(id, dto);
            return ResponseEntity.ok(marca);
        } catch (IllegalArgumentException error) {
            if (error instanceof ErrorValidate) {
                return ResponseEntity.badRequest().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }
}
