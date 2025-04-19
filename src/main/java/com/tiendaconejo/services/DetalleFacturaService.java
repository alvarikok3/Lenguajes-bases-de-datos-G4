package com.tiendaconejo.services;

import com.tiendaconejo.domain.DetalleFactura;
import java.util.List;

/**
 *
 * @author XPC
 */
public interface DetalleFacturaService {
    public List<DetalleFactura> getDetalleFacturas();
    
    public DetalleFactura getDetalleFactura(DetalleFactura detalleFactura);
    public void save(DetalleFactura detalleFactura);
    public void update(DetalleFactura detalleFactura);
    public void delete(DetalleFactura detalleFactura);
}
