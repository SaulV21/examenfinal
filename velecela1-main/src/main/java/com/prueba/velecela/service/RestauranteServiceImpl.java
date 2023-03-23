package com.prueba.velecela.service;

import com.prueba.velecela.models.Restaurante;
import com.prueba.velecela.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RestauranteServiceImpl extends GenericServiceImpl<Restaurante, Long> implements RestauranteService {
    @Autowired
    RestauranteRepository prof;
    @Override
    public CrudRepository<Restaurante, Long> getDao() {
        return prof;
    }
}
