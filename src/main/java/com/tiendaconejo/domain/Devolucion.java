package com.tiendaconejo.domain;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Data
@Entity
@Table(name = "DEVOLUCIONES")
public class Devolucion {

    @Id
    @Column(name = "ID_DEVOLUCION")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ID_FACTURA")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO")
    private Producto producto;

    private String motivo;
    private Date fecha;
}
