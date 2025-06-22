package cl.perfulandia.service;

import cl.perfulandia.clients.EnvioBsClient;
import cl.perfulandia.clients.PedidoBsClient;
import cl.perfulandia.model.dto.EnvioDTO;
import cl.perfulandia.model.dto.PedidoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {
    private final EnvioBsClient envioBsClient;
    private final PedidoBsClient pedidoBsClient;

    public EnvioService(EnvioBsClient envioDbClient, PedidoBsClient pedidoBsClient) {
        this.envioBsClient = envioDbClient;
        this.pedidoBsClient = pedidoBsClient;
    }

    public List<EnvioDTO> findAll() {
        return envioBsClient.findAll();
    }

    public EnvioDTO findById(Long id) {
        return envioBsClient.findById(id);
    }

    public EnvioDTO save(EnvioDTO envio) {
        // Validar que el pedido exista antes de crear el envío
        PedidoDTO pedido = pedidoBsClient.findById(envio.getPedidoId());
        if (pedido == null) {
            throw new RuntimeException("Pedido no encontrado para el envío");
        }
        return envioBsClient.save(envio);
    }

    public void deleteById(Long id) {
        envioBsClient.deleteById(id);
    }
}