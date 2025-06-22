package cl.perfulandia.service;

import cl.perfulandia.clients.PedidoBsClient;
import cl.perfulandia.model.dto.PedidoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoBffService {
    private final PedidoBsClient pedidoBsClient;

    public PedidoBffService(PedidoBsClient pedidoBsClient) {
        this.pedidoBsClient = pedidoBsClient;
    }

    public List<PedidoDTO> findAll() {
        return pedidoBsClient.findAll();
    }

    public PedidoDTO findById(Long id) {
        return pedidoBsClient.findById(id);
    }

    public PedidoDTO save(PedidoDTO pedido) {
        return pedidoBsClient.save(pedido);
    }

    public void deleteById(Long id) {
        pedidoBsClient.deleteById(id);
    }
}