package com.tiendaconejo.domain;

import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "ROL")
public class Rol {

    @Id
    @Column(name = "ID_ROL")
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "rol")
    private List<UsuarioRol> usuarios;

}
