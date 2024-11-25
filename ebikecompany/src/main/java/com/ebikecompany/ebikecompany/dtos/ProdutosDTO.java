package com.ebikecompany.ebikecompany.dtos;

import com.ebikecompany.ebikecompany.models.CategoriasEntity;
import com.ebikecompany.ebikecompany.models.MarcaEntity;

public record ProdutosDTO(String nome, String descricao, Double valor, Integer quantidade, String tamanho, MarcaEntity marca, CategoriasEntity categorias) {
}
