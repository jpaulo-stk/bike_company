package com.ebikecompany.ebikecompany.models;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria_produto")
public class CategoriaProdutoEntity {

    @EmbeddedId
    private CategoriaProdutoPK id;

    public CategoriaProdutoPK getId() {
        return id;
    }

    public void setId(CategoriaProdutoPK id) {
        this.id = id;
    }
}
