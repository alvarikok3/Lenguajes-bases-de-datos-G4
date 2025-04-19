package com.tiendaconejo.domain;

import jakarta.persistence.*;
import java.io.Serializable;

import lombok.Data;

@Data
@Entity
@Table(name="CATEGORIAS")
public class Categoria implements Serializable {
    private static final long serialVersionUID = 11;
    
    private Long id_categoria;
    private String nombre;
    
    

}
