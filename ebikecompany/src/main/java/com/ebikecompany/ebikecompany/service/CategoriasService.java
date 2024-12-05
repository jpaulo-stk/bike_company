package com.ebikecompany.ebikecompany.service;

import com.ebikecompany.ebikecompany.Errors.ErrorValidate;
import com.ebikecompany.ebikecompany.dtos.CategoriasRequestDTO;
import com.ebikecompany.ebikecompany.models.CategoriasEntity;
import com.ebikecompany.ebikecompany.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


 interface ICategoriasService {
    CategoriasEntity criarCategoria(CategoriasRequestDTO dto);
    List<CategoriasEntity> lerCategorias();
    CategoriasEntity lerCategoriasPorId(Integer id);
    void deletarCategoria(Integer id);
    CategoriasEntity atualizarCategoria(Integer id, CategoriasRequestDTO dto);
}

@Service
public class CategoriasService extends BaseCrudService<CategoriasEntity>  implements ICategoriasService {

    @Autowired
    CategoriasRepository categoriasRepository;

    @Autowired
    ValidationService validationService;

    @Override protected CategoriasRepository getRepository() {
        return categoriasRepository;
    }

    public CategoriasEntity criarCategoria (CategoriasRequestDTO dto) {
    CategoriasEntity categorias = new CategoriasEntity();
    Boolean validate = this.validationService.validation(dto.name());
    if(!validate) {
         throw new IllegalArgumentException("para cadastrar uma categorias precisa ter mais de 3 caracteres");
    }
    categorias.setNome(dto.name());
    criar(categorias);
    return  categorias;
}

    public List<CategoriasEntity> lerCategorias () {
        List<CategoriasEntity> categories = lerTodos();
        return categories;
    }

    public  CategoriasEntity lerCategoriasPorId (Integer id) {
       CategoriasEntity categorias =  lerPorId(id);
        return categorias;
    }

    public void deletarCategoria (Integer id) {
        deletar(id);
    }

    public  CategoriasEntity atualizarCategoria (Integer id ,CategoriasRequestDTO dto) {
        CategoriasEntity categorias =lerPorId(id);
         Boolean validate = this.validationService.validation(dto.name());
         if(!validate) {
             throw new ErrorValidate(" e necessario ao menos 5 caracteres para atualizar o nome");
         }
         categorias.setNome(dto.name());
         criar(categorias);
         return categorias;
    }
}
