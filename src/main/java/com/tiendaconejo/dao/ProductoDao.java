
package com.tiendaconejo.dao;

import com.tiendaconejo.domain.Producto;
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
public interface ProductoDao extends JpaRepository<Producto, Long> {
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE Productos p "
            + "SET p.nombre = :v_nombre, "
            + "p.precio = :v_precio, "
            + "p.id_categoria = :v_id_categoria, "
            + "p.id_proveedor = :v_id_proveedor "
            + "p_stock = :v_stock"
            + "p_estado = :v_estado"
            + "WHERE p.id_producto = :id", nativeQuery = true)
    int update(
        @Param("id") Long id,
        @Param("v_nombre") String nombre,
        @Param("v_precio") Double precio,
        @Param("v_idcategoria") Long idCategoria,
        @Param("v_idproveedor") Long idProveedor,
        @Param("v_stock") Integer stock,
        @Param("v_estado") String estado
    );
    
    @Transactional
   @Procedure(procedureName= "insertar_producto")
   void insertar_producto(
           @Param("p_id_categoria") Long idCategoria,
           @Param("p_id_proveedor") Long idProveedor,
           @Param("p_nombre") String nombre,
           @Param("p_precio") Long precio,
           @Param("p_stock") Integer stock,
           @Param("p_estado") String estado
           );   
}
