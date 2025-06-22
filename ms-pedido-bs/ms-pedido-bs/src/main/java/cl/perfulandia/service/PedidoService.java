package cl.perfulandia.service;

import cl.perfulandia.clients.PedidoDbClient;
import cl.perfulandia.clients.UsuarioClient;
import cl.perfulandia.clients.CatalogoClient;
import cl.perfulandia.model.dto.PedidoDTO;
import cl.perfulandia.model.dto.UsuarioDTO;
import cl.perfulandia.model.dto.CatalogoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {
    private final PedidoDbClient pedidoDbClient;
    private final UsuarioClient usuarioClient;
    private final CatalogoClient catalogoClient;

    public PedidoService(PedidoDbClient pedidoDbClient, UsuarioClient usuarioClient, CatalogoClient catalogoClient) {
        this.pedidoDbClient = pedidoDbClient;
        this.usuarioClient = usuarioClient;
        this.catalogoClient = catalogoClient;
    }

    public List<PedidoDTO> findAll() {
        return pedidoDbClient.findAll();
    }

    public PedidoDTO findById(Long id) {
        return pedidoDbClient.findById(id);
    }

    public PedidoDTO save(PedidoDTO pedido) {
        // Validar usuario y producto antes de guardar
        UsuarioDTO usuario = usuarioClient.obtener(pedido.getClienteId());
        CatalogoDTO producto = catalogoClient.getById(pedido.getProductoId());
        if (usuario == null || producto == null) {
            throw new RuntimeException("Usuario o producto no encontrado");
        }
        return pedidoDbClient.save(pedido);
    }

    public void deleteById(Long id) {
        pedidoDbClient.deleteById(id);
    }
}