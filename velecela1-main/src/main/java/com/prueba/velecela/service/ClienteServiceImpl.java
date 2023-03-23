package com.prueba.velecela.service;

import com.prueba.velecela.models.Cliente;
import com.prueba.velecela.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl extends GenericServiceImpl<Cliente,Long> implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public CrudRepository getDao() {
        return clienteRepository;
    }
}
