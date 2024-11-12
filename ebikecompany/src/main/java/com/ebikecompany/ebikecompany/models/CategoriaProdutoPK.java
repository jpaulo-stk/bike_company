package com.ebikecompany.ebikecompany.models;

import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;

@Embeddable
public class CategoriaProdutoPK implements Serializable {

    @ManyToOne
    private ProdutosEntity id_produto;

    @ManyToOne
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

    @Override
    public int hashCode() {
        return 31 * id_produto.hashCode() + id_categoria.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CategoriaProdutoPK that = (CategoriaProdutoPK) obj;
        return id_produto.equals(that.id_produto) && id_categoria.equals(that.id_categoria);
    }
}
