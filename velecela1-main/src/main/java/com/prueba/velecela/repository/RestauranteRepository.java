package com.prueba.velecela.repository;

import com.prueba.velecela.models.Restaurante;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RestauranteRepository extends MongoRepository<Restaurante, Long> {
}
