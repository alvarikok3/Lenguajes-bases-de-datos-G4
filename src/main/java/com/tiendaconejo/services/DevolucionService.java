/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tiendaconejo.services;

import com.tiendaconejo.domain.Devolucion;
import java.util.List;

/**
 *
 * @author XPC
 */
public interface DevolucionService {
    public List<Devolucion> getDevoluciones();
    
    public Devolucion getDevolucion(Devolucion devolucion);
    public void save(Devolucion devolucion);
    public void update(Devolucion devolucion);
    public void delete(Devolucion devolucion);
}
