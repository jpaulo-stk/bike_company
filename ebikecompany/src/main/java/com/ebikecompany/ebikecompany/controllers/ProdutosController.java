package com.ebikecompany.ebikecompany.controllers;

import com.ebikecompany.ebikecompany.dtos.ProdutosDTO;
import com.ebikecompany.ebikecompany.models.ProdutosEntity;
import com.ebikecompany.ebikecompany.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosRepository repository;

    @GetMapping
    public ResponseEntity<List<ProdutosEntity>> findAll() {
        List<ProdutosEntity> produtos = this.repository.findAll();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ProdutosEntity findById(@PathVariable Integer id) {
        return this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não foi encontrado"));
    }

    @PostMapping
    public ResponseEntity<ProdutosEntity> save(@RequestBody ProdutosDTO dto) {
        if (dto.nome().isEmpty()) {
            return  ResponseEntity.status(428).build();
        }

        ProdutosEntity produto = new ProdutosEntity();
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setValor(dto.valor());
        produto.setQuantidade(dto.quantidade());
        produto.setTamanho(dto.tamanho());
        produto.setMarca(dto.marca());
        produto.setCategorias(dto.categorias());

        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        ProdutosEntity produto = this.repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        this.repository.delete(produto);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosEntity> update(@PathVariable Integer id, @RequestBody ProdutosDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(428).build();
        }

        ProdutosEntity produto = this.repository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Produto não foir encontrado"));

        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setValor(dto.valor());
        produto.setQuantidade(dto.quantidade());
        produto.setTamanho(dto.tamanho());
        produto.setMarca(dto.marca());
        produto.setCategorias(dto.categorias());

        this.repository.save(produto);
        return ResponseEntity.ok(produto);
    }
}
