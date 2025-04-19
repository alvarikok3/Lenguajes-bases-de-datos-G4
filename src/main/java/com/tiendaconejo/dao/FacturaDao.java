package com.tiendaconejo.dao;

import com.tiendaconejo.domain.Factura;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author XPC
 */
public interface FacturaDao extends JpaRepository<Factura, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE FACTURAS f "
            + "SET f.FECHA = :fecha, "
            + "f.TOTAL = :total, "
            + "f.ID_USUARIO = :idUsuario "
            + "WHERE f.ID_FACTURA = :idFactura", nativeQuery = true)
    int update(
            @Param("idFactura") Long idFactura,
            @Param("fecha") LocalDate fecha,
            @Param("total") Double total,
            @Param("idUsuario") Long idUsuario
    );

    @Transactional
    @Procedure(procedureName = "insertar_factura")
    void insertar_factura(
            @Param("p_total") Long total,
            @Param("p_id_usuario") Long idUsuario
    );
}
