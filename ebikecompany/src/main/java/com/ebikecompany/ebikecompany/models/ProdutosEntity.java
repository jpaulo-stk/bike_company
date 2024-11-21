package com.ebikecompany.ebikecompany.models;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class ProdutosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private Integer id_produto;

    @Column(name = "nome")
    private String nome;

    @Column(name = "desc")
    private String desc;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "quantidade")
    private Integer quantidade;

    @Column(name = "card_image")
    private String card_image;

    @Column(name = "tamanho")
    private String tamanho;

    @ManyToOne
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    private CategoriasEntity categoria;

    @ManyToOne
    @JoinColumn(name = "id_marca", referencedColumnName = "id_marca")
    private MarcaEntity marca;

    public Integer getId_produto() {
        return id_produto;
    }

    public void setId_produto(Integer id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCard_image() {
        return card_image;
    }

    public void setCard_image(String card_image) {
        this.card_image = card_image;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public CategoriasEntity getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriasEntity categoria) {
        this.categoria = categoria;
    }

    public MarcaEntity getMarca() {
        return marca;
    }

    public void setMarca(MarcaEntity marca) {
        this.marca = marca;
    }
}
