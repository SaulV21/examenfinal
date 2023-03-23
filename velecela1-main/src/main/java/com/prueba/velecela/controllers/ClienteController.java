package com.prueba.velecela.controllers;

import com.prueba.velecela.models.Cliente;
import com.prueba.velecela.models.Restaurante;
import com.prueba.velecela.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    @GetMapping("/listarcliente")
    public ResponseEntity<List<Cliente>> listarCliente() {
        return new ResponseEntity<>(clienteService.findByAll(),
                HttpStatus.OK);
    }
    @PostMapping("/crearcliente")
    public ResponseEntity<Cliente> crear(
            @RequestBody Cliente p) {
        return new ResponseEntity<>(clienteService.save(p),
                HttpStatus.CREATED);
    }

    @PutMapping("/actualizarcliente/{id}")
    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody Cliente p) {
        Cliente ok = clienteService.findById(id);
        if (ok == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                ok.setNombre(p.getNombre());
                ok.setApellido(p.getApellido());
                ok.setCedula(p.getCedula());
                ok.setCorreo(p.getCorreo());
                return new ResponseEntity<>(clienteService.save(p), HttpStatus.OK);
            } catch (DataAccessException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @DeleteMapping("/eliminarcliente/{id}")
    public ResponseEntity<Restaurante> eliminar(@PathVariable Long id) {
        clienteService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
