package cl.perfulandia.service;

import cl.perfulandia.clients.EnvioDbClient;
import cl.perfulandia.clients.PedidoClient;
import cl.perfulandia.model.dto.EnvioDTO;
import cl.perfulandia.model.dto.PedidoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {
    private final EnvioDbClient envioDbClient;
    private final PedidoClient pedidoClient;

    public EnvioService(EnvioDbClient envioDbClient, PedidoClient pedidoBsClient) {
        this.envioDbClient = envioDbClient;
        this.pedidoClient = pedidoBsClient;
    }

    public List<EnvioDTO> findAll() {
        return envioDbClient.findAll();
    }

    public EnvioDTO findById(Long id) {
        return envioDbClient.findById(id);
    }

    public EnvioDTO save(EnvioDTO envio) {
        // Validar que el pedido exista antes de crear el envío
        PedidoDTO pedido = pedidoClient.findById(envio.getPedidoId());
        if (pedido == null) {
            throw new RuntimeException("Pedido no encontrado para el envío");
        }
        return envioDbClient.save(envio);
    }

    public void deleteById(Long id) {
        envioDbClient.deleteById(id);
    }
}