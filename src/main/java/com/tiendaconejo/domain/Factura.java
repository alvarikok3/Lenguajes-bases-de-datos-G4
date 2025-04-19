package com.tiendaconejo.domain;

/**
 *
 * @author XPC
 */
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "FACTURAS")
public class Factura {

    @Id
    @Column(name = "ID_FACTURA")
    private Long id;

    private Date fecha;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @OneToMany(mappedBy = "factura")
    private List<DetalleFactura> detalles;

    @OneToMany(mappedBy = "factura")
    private List<Devolucion> devoluciones;
}
