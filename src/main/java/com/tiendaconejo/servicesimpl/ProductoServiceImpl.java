package com.tiendaconejo.servicesimpl;

import com.tiendaconejo.dao.ProductoDao;
import com.tiendaconejo.domain.Producto;
import com.tiendaconejo.services.ProductoService;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    public List<Producto> getProductos() {
        //findAll trae todos los datos de la tabla como tal
        var lista = productoDao.findAll();

        //lista.removeIf(c -> !c.getEstado().equals("A"));
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.insertar_producto(
                producto.getIdCategoria().getId_categoria(),
                producto.getIdProveedor().getId(),
                producto.getNombre(),
                producto.getPrecio().longValue(), // Convertir Double a Long
                producto.getStock(),
                producto.getEstado()
        );
    }

    @Override
    @Transactional
    public void update(Producto producto) {
        productoDao.update(
                producto.getId(), // id del producto
                producto.getNombre(), // nombre
                producto.getPrecio(), // precio (ya es Double)
                producto.getIdCategoria().getId_categoria(), // id de la categoría
                producto.getIdProveedor().getId(), // id del proveedor
                producto.getStock(), // stock
                producto.getEstado() // estado
        ); 
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    }

}
