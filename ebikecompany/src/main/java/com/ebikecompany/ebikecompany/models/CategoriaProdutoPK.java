package com.ebikecompany.ebikecompany.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class CategoriaProdutoPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @JsonIgnoreProperties("categorias")
    private ProdutosEntity id_produto;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private CategoriasEntity id_categoria;

    public ProdutosEntity getId_produto() {
        return id_produto;
    }

    public void setId_produto(ProdutosEntity id_produto) {
        this.id_produto = id_produto;
    }

    public CategoriasEntity getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(CategoriasEntity id_categoria) {
        this.id_categoria = id_categoria;
    }
}
