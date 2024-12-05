package com.ebikecompany.ebikecompany.service;

import com.ebikecompany.ebikecompany.models.CategoriasEntity;
import com.ebikecompany.ebikecompany.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public  class ValidationService  {

    public Boolean validation(String valor) {
        return valor.length() > 3;
    }

}
