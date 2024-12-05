package com.ebikecompany.ebikecompany.controllers;

import com.ebikecompany.ebikecompany.dtos.ProdutosDTO;
import com.ebikecompany.ebikecompany.models.ProdutosEntity;
import com.ebikecompany.ebikecompany.repository.ProdutosRepository;
import com.ebikecompany.ebikecompany.service.ProdutosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosRepository repository;

    @Autowired
    private ProdutosServices produtosServices;

    @GetMapping
    public ResponseEntity<List<ProdutosEntity>> findAll() {
        return this.produtosServices.pegarTodosProdutos();
    }

    @GetMapping("/{id}")
    public ProdutosEntity findById(@PathVariable Integer id) {
      return  this.produtosServices.lerPorId(id);
    }

    @PostMapping
    public ResponseEntity<ProdutosEntity> save(@RequestBody ProdutosDTO dto) {
      return this.produtosServices.criarProduto(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        this.produtosServices.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosEntity> update(@PathVariable Integer id, @RequestBody ProdutosDTO dto) {
      return  this.produtosServices.atualizarProduto(id,dto);
    }
}
