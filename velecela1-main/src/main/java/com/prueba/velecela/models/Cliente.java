package com.prueba.velecela.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "cliente")
@Data
public class Cliente {
    @Id
    private Long id_cli;
    private String nombre;
    private String apellido;
    private String cedula;
    private String correo;

}
