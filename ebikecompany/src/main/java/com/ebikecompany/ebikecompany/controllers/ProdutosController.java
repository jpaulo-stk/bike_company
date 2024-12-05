package com.ebikecompany.ebikecompany.controllers;

import com.ebikecompany.ebikecompany.Errors.ErrorValidate;
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
       List<ProdutosEntity> produtos = this.produtosServices.pegarTodosProdutos();;
       return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosEntity> pegarProdutoPeloId(@PathVariable Integer id) {
        try{
            ProdutosEntity produtos = this.produtosServices.pegarProdutoPeloId(id);
            return ResponseEntity.ok(produtos);
        } catch (IllegalArgumentException e) {
           return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<ProdutosEntity> criarProduto(@RequestBody ProdutosDTO dto) {
        try{
            ProdutosEntity produtos = this.produtosServices.criarProduto(dto);
            return ResponseEntity.ok(produtos);
        } catch (IllegalArgumentException e) {
            if(e instanceof ErrorValidate) {
                return ResponseEntity.badRequest().build();
            }
                return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdutoPeloId(@PathVariable Integer id) {
        try{
            this.produtosServices.deletarProduto(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException error) {
            return  ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosEntity> atualizarProdutoPeloId(@PathVariable Integer id, @RequestBody ProdutosDTO dto) {
        try{
            ProdutosEntity produtos = this.produtosServices.atualizarProduto(id, dto);
            return ResponseEntity.ok(produtos);
        } catch (IllegalArgumentException error) {
            if (error instanceof ErrorValidate) {
               return  ResponseEntity.badRequest().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    }
}
