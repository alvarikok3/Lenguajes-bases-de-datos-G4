/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tiendaconejo.dao;

import com.tiendaconejo.domain.Usuario;
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
public interface UsuarioDao extends JpaRepository<Usuario, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE USUARIO u "
            + "SET u.NOMBRE = :nombre, "
            + "u.TELEFONO = :telefono, "
            + "u.DIRECCION = :direccion, "
            + "u.EMAIL = :email, "
            + "u.CONTRASENA = :contrasena "
            + "WHERE u.ID_USUARIO = :idUsuario", nativeQuery = true)
    int update(
            @Param("idUsuario") Long idUsuario,
            @Param("nombre") String nombre,
            @Param("telefono") String telefono,
            @Param("direccion") String direccion,
            @Param("email") String email,
            @Param("contrasena") String contrasena
    );

    @Transactional
    @Procedure(procedureName = "insertar_usuario")
    void insertar_usuario(
            @Param("p_nombre") String nombre,
            @Param("p_telefono") Integer telefono,
            @Param("p_direccion") String direccion,
            @Param("p_email") String email,
            @Param("p_contraseña") String contrasena
    );
}
