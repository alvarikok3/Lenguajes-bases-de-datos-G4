package com.tiendaconejo.services;

import com.tiendaconejo.domain.Usuario;
import java.util.List;

/**
 *
 * @author XPC
 */
public interface UsuarioService {
    public List<Usuario> getUsuarios();
    
    public Usuario getUsuario(Usuario usuario);
    public void save(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(Usuario usuario);
}
