package cl.perfulandia.clients;

import cl.perfulandia.model.dto.PedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-pedido-bs", url = "http://localhost:8087")
public interface PedidoBsClient {
    @GetMapping("/pedidos/{id}")
    PedidoDTO findById(@PathVariable("id") Long id);
}