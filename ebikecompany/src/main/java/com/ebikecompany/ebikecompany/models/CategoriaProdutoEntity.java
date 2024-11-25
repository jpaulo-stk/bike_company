package com.ebikecompany.ebikecompany.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "categoria_produto")
public class CategoriaProdutoEntity {

    @EmbeddedId
    private CategoriaProdutoPK id;

    @Column(name = "date_cat_pro")
    private LocalDate Produto_Date;

    public CategoriaProdutoPK getId() {
        return id;
    }

    public void setId(CategoriaProdutoPK id) {
        this.id = id;
    }

    public LocalDate getProduto_Date() {
        return Produto_Date;
    }

    public void setProduto_Date(LocalDate produto_Date) {
        Produto_Date = produto_Date;
    }
}
