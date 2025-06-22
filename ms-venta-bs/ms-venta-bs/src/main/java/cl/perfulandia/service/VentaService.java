package cl.perfulandia.service;

import cl.perfulandia.clients.UsuarioClient;
import cl.perfulandia.clients.CatalogoClient;
import cl.perfulandia.clients.VentaDbClient;
import cl.perfulandia.model.dto.VentaDTO;
import cl.perfulandia.model.dto.UsuarioDTO;
import cl.perfulandia.model.dto.CatalogoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaDbClient ventaDbClient;

    @Autowired
    private UsuarioClient usuarioClient;

    @Autowired
    private CatalogoClient catalogoClient;

    public List<VentaDTO> findAll() {
        return ventaDbClient.findAll();
    }

    public VentaDTO findById(Long id) {
        return ventaDbClient.findById(id);
    }

    public VentaDTO save(VentaDTO venta) {
        // Ejemplo de lógica: validar usuario y catálogo antes de guardar
        UsuarioDTO usuario = usuarioClient.obtener(venta.getUsuarioId());
        CatalogoDTO catalogo = catalogoClient.getById(venta.getCatalogoId());
        if (usuario == null || catalogo == null) {
            throw new IllegalArgumentException("Usuario o catálogo no válido");
        }
        // Aquí podrías agregar lógica para descontar stock, etc.
        return ventaDbClient.save(venta);
    }

    public void deleteById(Long id) {
        ventaDbClient.deleteById(id);
    }
}