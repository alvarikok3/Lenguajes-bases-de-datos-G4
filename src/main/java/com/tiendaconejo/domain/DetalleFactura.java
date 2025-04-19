package com.tiendaconejo.domain;

/**
 *
 * @author XPC
 */
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "DETALLES_FACTURAS")
public class DetalleFactura {

    @Id
    @Column(name = "ID_DETALLEFACTURA")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_FACTURA")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO")
    private Producto producto;

    private Integer cantidad;
    private Double subtotal;
}

