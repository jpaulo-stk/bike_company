package com.ebikecompany.ebikecompany.service;

import com.ebikecompany.ebikecompany.Errors.ErrorValidate;
import com.ebikecompany.ebikecompany.dtos.ProdutosDTO;
import com.ebikecompany.ebikecompany.models.CategoriasEntity;
import com.ebikecompany.ebikecompany.models.ProdutosEntity;
import com.ebikecompany.ebikecompany.repository.MarcaRepository;
import com.ebikecompany.ebikecompany.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

interface IProdutosService {
    List<ProdutosEntity> pegarTodosProdutos();
    ProdutosEntity pegarProdutoPeloId(Integer id);
    ProdutosEntity criarProduto(ProdutosDTO produtosDTO);
    void deletarProduto(Integer id);
    ProdutosEntity atualizarProduto(Integer id, ProdutosDTO dto);
}

@Service
public class ProdutosServices extends BaseCrudService<ProdutosEntity> implements IProdutosService{

    @Autowired
    private CategoriasService categoriasService;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
     private ProdutosRepository produtosRepository;

    @Autowired
    private ValidationService validationService;

    @Override
    protected ProdutosRepository getRepository() {
        return  produtosRepository;
    }

    public List<ProdutosEntity> pegarTodosProdutos () {
        return lerTodos();
    }
    public ProdutosEntity  pegarProdutoPeloId(Integer id) {

        return  lerPorId(id);
    }


    public ProdutosEntity criarProduto(ProdutosDTO produtosDTO) {
        Boolean name = this.validationService.validation(produtosDTO.nome());
        if(!name) throw  new ErrorValidate("nome precisar de mais que 5 caracteres");
        CategoriasEntity categoriasEntity = this.categoriasService.lerCategoriasPorId(produtosDTO.categorias().getId_categoria());

        ProdutosEntity produtos = new ProdutosEntity();
        produtos.setNome(produtosDTO.nome());
        produtos.setDescricao(produtosDTO.descricao());
        produtos.setValor(produtosDTO.valor());
        produtos.setQuantidade(produtosDTO.quantidade());
        produtos.setTamanho(produtosDTO.tamanho());
        produtos.setMarca(produtosDTO.marca());
        produtos.setCategorias(produtosDTO.categorias());
        criar(produtos);
        return  produtos;
    }

    public void deletarProduto (Integer id) {
            deletar(id);
    }

    public ProdutosEntity atualizarProduto (Integer id, ProdutosDTO dto) {
        ProdutosEntity produto = lerPorId(id);
        Boolean validate = this.validationService.validation(dto.nome());
        CategoriasEntity categoriasEntity = this.categoriasService.lerCategoriasPorId(id);
        if (!validate) throw  new ErrorValidate("nome precisa ter mais que 3 caracteres");
        produto.setNome(dto.nome());
        produto.setDescricao(dto.descricao());
        produto.setValor(dto.valor());
        produto.setQuantidade(dto.quantidade());
        produto.setTamanho(dto.tamanho());
        produto.setMarca(dto.marca());
        produto.setCategorias(dto.categorias());

        criar(produto);
        return produto;
    }
}
