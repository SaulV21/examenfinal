package com.prueba.velecela.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "carta")
@Data
public class Carta {
    @Id
    private Long id_carta;
    private String nombre;
    private String categoria;
    private Integer cantidad;
    private List<Plato> listadeplatos;
}
