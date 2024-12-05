package com.ebikecompany.ebikecompany.service;

import com.ebikecompany.ebikecompany.dtos.CategoriasRequestDTO;
import com.ebikecompany.ebikecompany.models.CategoriasEntity;
import com.ebikecompany.ebikecompany.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriasService extends BaseCrudService<CategoriasEntity> {

    @Autowired CategoriasRepository categoriasRepository;
    @Autowired ValidationService validationService;

    @Override
    protected CategoriasRepository getRepository() {
        return categoriasRepository;
    }

public ResponseEntity<CategoriasEntity> criarCategoria (CategoriasRequestDTO dto) {
    CategoriasEntity categorias = new CategoriasEntity();
    Boolean validate = this.validationService.validation(dto.name());
    if(!validate) {
         throw new IllegalArgumentException("para cadastrar uma categorias precisa ter mais de 3 caracteres");
    }
    categorias.setNome(dto.name());
    criar(categorias);
    return  ResponseEntity.ok(categorias);
}

    public ResponseEntity<List<CategoriasEntity>>lerCategorias () {
        List<CategoriasEntity> categories = lerTodos();
        return ResponseEntity.ok(categories);
    }

    public ResponseEntity<CategoriasEntity> lerCategoriasPorId (Integer id) {
        System.out.println(id);
       CategoriasEntity categorias =  lerPorId(id);
        return ResponseEntity.ok(categorias);
    }


    public void deletarCategoria (Integer id) {
        deletar(id);

    }

    public ResponseEntity<CategoriasEntity> atualizarCategoria (Integer id ,CategoriasRequestDTO dto) {
        CategoriasEntity categorias =lerPorId(id);
         Boolean validate = this.validationService.validation(dto.name());
         if(!validate) {
             throw new IllegalArgumentException(" e necessario ao menos 5 caracteres para atualizar o nome");
         }
         categorias.setNome(dto.name());
         criar(categorias);
         return ResponseEntity.ok(categorias);
    }

}
