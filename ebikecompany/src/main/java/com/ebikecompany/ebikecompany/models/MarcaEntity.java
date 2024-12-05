package com.ebikecompany.ebikecompany.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "marca")
public class MarcaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_marca;

    @Column(name = "nome", length = 200)
    private String nome;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL)
    private List<ProdutosEntity> produtos;

    public List<ProdutosEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutosEntity> produtos) {
        this.produtos = produtos;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public MarcaEntity() {
    }

}