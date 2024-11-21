package com.ebikecompany.ebikecompany.controllers;

import com.ebikecompany.ebikecompany.models.ProdutosEntity;
import com.ebikecompany.ebikecompany.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/produtos")
public class ProdutosController {

    @Autowired
    private ProdutosRepository repository;

    @GetMapping
    public ResponseEntity<List<ProdutosEntity>> findAll() {
        List<ProdutosEntity> produtos = this.repository.findAll();
        return ResponseEntity.ok(produtos);
    }
}
