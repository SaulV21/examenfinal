package com.prueba.velecela.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "restaurante")
@Data
public class Restaurante {
    @Id
    private Long id_res;
    private String nombre;
    private String telefono;
    private String correo;
    private String direccion;
    private List <Cliente> listadodeclientes;
    private List <Carta> listadecartas;
}
