package com.ebikecompany.ebikecompany.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorias")
public class CategoriasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer id_categoria;

    @Column(name = "nome", length = 200)
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<ProdutosEntity> produtos;

    public Integer getId() {
        return id_categoria;
    }

    public void setId(Integer id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ProdutosEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutosEntity> produtos) {
        this.produtos = produtos;
    }
}