package com.ebikecompany.ebikecompany.service;

import com.ebikecompany.ebikecompany.Errors.ErrorValidate;
import com.ebikecompany.ebikecompany.dtos.MarcaDTO;
import com.ebikecompany.ebikecompany.models.MarcaEntity;
import com.ebikecompany.ebikecompany.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


interface IMarcaService {
    MarcaEntity criarMarca(MarcaDTO dto);
    List<MarcaEntity> pegarTodasMarcas();
    MarcaEntity pegarMarcaPeloId(Integer id);
    void deletarMarca(Integer id);
    MarcaEntity atualizarMarca(Integer id, MarcaDTO dto);
}


@Service
public class MarcaService extends BaseCrudService<MarcaEntity> implements IMarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private ValidationService validationService;

    @Override
    protected MarcaRepository getRepository() {
        return marcaRepository;
    }

    public MarcaEntity criarMarca(MarcaDTO dto) {
       Boolean validation = this.validationService.validation(dto.nome());
       if(!validation) throw new ErrorValidate("nome marca precisa de ao menos 3 caracteres");
        MarcaEntity marca = new MarcaEntity();
        marca.setNome(dto.nome());
        return getRepository().save(marca);
    }

    public List<MarcaEntity> pegarTodasMarcas() {
        return lerTodos();
    }

    public MarcaEntity pegarMarcaPeloId(Integer id) {
        return lerPorId(id);
    }

    public void deletarMarca(Integer id) {
        deletar(id);
    }

    public MarcaEntity atualizarMarca(Integer id, MarcaDTO dto) {
        MarcaEntity marca = lerPorId(id);
        Boolean validation = this.validationService.validation(dto.nome());
        if(!validation) throw new ErrorValidate("nome marca precisa de ao menos 3 caracteres");
        marca.setNome(dto.nome());
        return getRepository().save(marca);
    }
}
