/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tiendaconejo.dao;

import com.tiendaconejo.domain.DetalleFactura;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author XPC
 */
public interface DetalleFacturaDao extends JpaRepository<DetalleFactura, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE DETALLES_FACTURAS df "
            + "SET df.ID_FACTURA = :idFactura, "
            + "df.ID_PRODUCTO = :idProducto, "
            + "df.CANTIDAD = :cantidad, "
            + "df.SUBTOTAL = :subtotal "
            + "WHERE df.ID_DETALLESFACTURA = :idDetalle", nativeQuery = true)
    int update(
            @Param("idDetalle") Long idDetalle,
            @Param("idFactura") Long idFactura,
            @Param("idProducto") Long idProducto,
            @Param("cantidad") Integer cantidad,
            @Param("subtotal") Double subtotal
    );

    @Transactional
    @Procedure(procedureName = "insertar_detalle_factura")
    void insertar_detalle_factura(
            @Param("p_id_factura") Long idFactura,
            @Param("p_id_producto") Long idProducto,
            @Param("p_cantidad") Long cantidad,
            @Param("p_subtotal") Long subtotal);

}
