/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tiendaconejo.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author XPC
 */
public interface ProveedorDao {
    @Transactional
    @Modifying
    @Query(value = "UPDATE proovedores c "
            + "SET c.nombre = :nombre, "
            + "c.idDireccion = :iddireccion, "
            + "c.telefono = :telefono "
            + "WHERE c.idproveedor = :idproveedor"
            ,nativeQuery = true)
    int update(
            @Param("idproveedor") Long idProveedor,
            @Param("nombre") String nombre,
            @Param("direccion") String direccion,
            @Param("telefono") String telefono
    );
    
    
    @Transactional
    @Procedure(procedureName = "insertar_proovedor")
    void insertar_proovedor(
            @Param("p_nombre") String nombre,
            @Param("p_telefono") Integer telefono,
            @Param("p_direccion") String direccion
    );
}
