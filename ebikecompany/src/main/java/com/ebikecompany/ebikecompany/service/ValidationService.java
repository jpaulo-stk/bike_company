package com.ebikecompany.ebikecompany.service;

import org.springframework.stereotype.Service;

@Service
public  class ValidationService {
    public Boolean validation(String valor) {
        return valor.length() > 5;
    }
}
