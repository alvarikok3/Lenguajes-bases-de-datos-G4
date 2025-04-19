
package com.tiendaconejo.dao;

import com.tiendaconejo.domain.Categoria;
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
public interface CategoriaDao extends JpaRepository<Categoria,Long>{
    
    @Transactional
    @Modifying
    @Query("UPDATE Categorias c SET c.nombre = :V_Nombre WHERE c.id = :id")
    int update(
            @Param("id") Long id,
            @Param("V_Nombre") String nombre
    );
    
   @Transactional
   @Procedure(procedureName= "insertar_categoria")
   void insertar_categoria(
    @Param("p_nombre") String nombre);
    
}
