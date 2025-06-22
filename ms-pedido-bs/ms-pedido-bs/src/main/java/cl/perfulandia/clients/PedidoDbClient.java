package cl.perfulandia.clients;

import cl.perfulandia.model.dto.PedidoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-pedido-db", url = "http://localhost:8087")
public interface PedidoDbClient {
    @GetMapping("/pedidos")
    List<PedidoDTO> findAll();

    @GetMapping("/pedidos/{id}")
    PedidoDTO findById(@PathVariable("id") Long id);

    @PostMapping("/pedidos")
    PedidoDTO save(@RequestBody PedidoDTO pedido);

    @DeleteMapping("/pedidos/{id}")
    void deleteById(@PathVariable("id") Long id);
}