package com.tiendaconejo.domain;

/**
 *
 * @author XPC
 */
import jakarta.persistence.*;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "USUARIO")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO")
    private Long id;

    private String nombre;
    private Long telefono;
    private String direccion;
    private String email;
    private String contrasena;

    @OneToMany(mappedBy = "usuario")
    private List<Factura> facturas;

    @OneToMany(mappedBy = "usuario")
    private List<UsuarioRol> roles;
    

}