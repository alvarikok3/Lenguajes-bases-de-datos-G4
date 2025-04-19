package com.tiendaconejo.dao;

import com.tiendaconejo.domain.Rol;
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
public interface RolDao extends JpaRepository<Rol, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE ROL r "
            + "SET r.NOMBRE = :nombre "
            + "WHERE r.ID_ROL = :idRol", nativeQuery = true)
    int update(
            @Param("idRol") Long idRol,
            @Param("nombre") String nombre
    );

    @Transactional
    @Procedure(procedureName = "insertar_rol")
    void insertar_rol(
            @Param("p_nombre") String nombre
    );

}
