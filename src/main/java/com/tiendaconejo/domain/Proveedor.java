package com.tiendaconejo.domain;

/**
 *
 * @author XPC
 */
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Data
@Entity
@Table(name = "PROVEEDORES")
public class Proveedor {

    @Id
    @Column(name = "ID_PROVEEDOR")
    private Long id;

    private String nombre;
    private Long telefono;
    private String direccion;

    @OneToMany(mappedBy = "proveedor")
    private List<Producto> productos;
}
