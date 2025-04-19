
package com.tiendaconejo.servicesimpl;

import com.tiendaconejo.dao.CategoriaDao;
import com.tiendaconejo.domain.Categoria;
import com.tiendaconejo.services.CategoriaService;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    public List<Categoria> getCategorias() {
        //findAll trae todos los datos de la tabla como tal
        var lista = categoriaDao.findAll();

        //lista.removeIf(c -> !c.getEstado().equals("A"));
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getId_categoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.insertar_categoria(categoria.getNombre());
    }

    @Override
    @Transactional
    public void update(Categoria categoria) {
        categoriaDao.update(categoria.getId_categoria(), categoria.getNombre());
    }
    
    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

}
