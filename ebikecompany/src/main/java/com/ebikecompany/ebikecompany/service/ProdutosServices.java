package com.ebikecompany.ebikecompany.service;

import com.ebikecompany.ebikecompany.dtos.ProdutosDTO;
import com.ebikecompany.ebikecompany.models.CategoriasEntity;
import com.ebikecompany.ebikecompany.models.ProdutosEntity;
import com.ebikecompany.ebikecompany.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class ProdutosServices extends BaseCrudService<ProdutosEntity> {

    @Autowired
   private ProdutosRepository produtosRepository;

    @Autowired
    private ValidationService validationService;

    @Override
    protected ProdutosRepository getRepository() {
        return  produtosRepository;
    }

    public ResponseEntity<List<ProdutosEntity>> pegarTodosProdutos () {
        List<ProdutosEntity> produtos = lerTodos();
        return ResponseEntity.ok(produtos);
    }
    public ResponseEntity<ProdutosEntity>  pegarProdutoPeloId(Integer id) {
        ProdutosEntity produtos = lerPorId(id);
        return ResponseEntity.ok(produtos);
    }

    public ResponseEntity<ProdutosEntity> criarProduto(ProdutosDTO produtosDTO) {
        Boolean name = this.validationService.validation(produtosDTO.nome());
        if (!name)   return ResponseEntity.status(428).build();
        ProdutosEntity produtos = new ProdutosEntity();
        produtos.setNome(produtosDTO.nome());
        produtos.setDescricao(produtosDTO.descricao());
        produtos.setValor(produtosDTO.valor());
        produtos.setQuantidade(produtosDTO.quantidade());
        produtos.setTamanho(produtosDTO.tamanho());
        produtos.setMarca(produtosDTO.marca());
        produtos.setCategorias(produtosDTO.categorias());
        criar(produtos);
        return  ResponseEntity.ok(produtos);
    }
    public void deletarProduto (Integer id) {
            deletar(id);
    }

    public ResponseEntity<ProdutosEntity> atualizarProduto (Integer id, ProdutosDTO dto) {
        ProdutosEntity produto = lerPorId(id);
        Boolean validate = this.validationService.validation(dto.nome());
        if (!validate)  return ResponseEntity.status(428).build();
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setValor(dto.valor());
        produto.setQuantidade(dto.quantidade());
        produto.setTamanho(dto.tamanho());
        produto.setMarca(dto.marca());
        produto.setCategorias(dto.categorias());

        criar(produto);
        return ResponseEntity.ok(produto);
    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<ProdutosEntity> update(@PathVariable Integer id, @RequestBody ProdutosDTO dto) {
//        if (dto.nome().isEmpty()) {
//            return ResponseEntity.status(428).build();
//        }
//
//        ProdutosEntity produto = this.repository.findById(id)
//                .orElseThrow(() ->
//                        new IllegalArgumentException("Produto não foir encontrado"));
//
//        produto.setNome(dto.nome());
//        produto.setDescricao(dto.descricao());
//        produto.setValor(dto.valor());
//        produto.setQuantidade(dto.quantidade());
//        produto.setTamanho(dto.tamanho());
//        produto.setMarca(dto.marca());
//        produto.setCategorias(dto.categorias());
//
//        this.repository.save(produto);
//        return ResponseEntity.ok(produto);
//    }



}
