package com.prueba.velecela.controllers;

import com.prueba.velecela.models.Restaurante;
import com.prueba.velecela.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurante")
public class RestauranteController {
    @Autowired
    RestauranteService restauranteService;
    @GetMapping("/listar")
    public ResponseEntity<List<Restaurante>> listarRestaurante() {
        return new ResponseEntity<>(restauranteService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crear")
    public ResponseEntity<Restaurante> crear(
            @RequestBody Restaurante p) {
        return new ResponseEntity<>(restauranteService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Restaurante> actualizar(@PathVariable Long id, @RequestBody Restaurante p) {
        Restaurante ok = restauranteService.findById(id);
        if (ok == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                ok.setNombre(p.getNombre());
                ok.setTelefono(p.getTelefono());
                ok.setCorreo(p.getCorreo());
                ok.setDireccion(p.getDireccion());
                return new ResponseEntity<>(restauranteService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Restaurante> eliminar(@PathVariable Long id) {
        restauranteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
