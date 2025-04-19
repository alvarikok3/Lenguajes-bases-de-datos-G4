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
@Table(name = "PRODUCTOS")
public class Producto {

    @Id
    @Column(name = "ID_PRODUCTO")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_CATEGORIA")
    private Categoria idCategoria;

    @ManyToOne
    @JoinColumn(name = "ID_PROVEEDOR")
    private Proveedor idProveedor;

    private String nombre;
    private Double precio;
    private Integer stock;
    private String estado;

    @OneToMany(mappedBy = "producto")
    private List<DetalleFactura> detalles;

    @OneToMany(mappedBy = "producto")
    private List<Devolucion> devoluciones;
}