package com.tiendaconejo.dao;

import java.time.LocalDate;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author XPC
 */
public interface DevolucionDao {

    @Transactional
    @Modifying
    @Query(value = "UPDATE DEVOLUCIONES d "
            + "SET d.ID_FACTURA = :idFactura, "
            + "d.ID_PRODUCTO = :idProducto, "
            + "d.MOTIVO = :motivo, "
            + "d.FECHA = :fecha "
            + "WHERE d.ID_DEVOLUCION = :idDevolucion", nativeQuery = true)
    int update(
            @Param("idDevolucion") Long idDevolucion,
            @Param("idFactura") Long idFactura,
            @Param("idProducto") Long idProducto,
            @Param("motivo") String motivo,
            @Param("fecha") LocalDate fecha
    );

    @Transactional
    @Procedure(procedureName = "insertar_devolucion")
    void insertar_devolucion(
            @Param("p_id_factura") Long total,
            @Param("p_id_usuario") Long idUsuario,
            @Param("p_motivo") String motivo
    );
}
