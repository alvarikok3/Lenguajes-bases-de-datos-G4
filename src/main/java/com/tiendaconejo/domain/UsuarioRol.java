package com.tiendaconejo.domain;

/**
 *
 * @author XPC
 */
import jakarta.persistence.*;
import lombok.*;
@Data
@Entity
@Table(name = "USUARIO_ROL")
public class UsuarioRol {

    @Id
    @Column(name = "ID_USUARIO_ROL")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "ID_ROL")
    private Rol rol;

}
