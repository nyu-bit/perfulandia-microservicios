package cl.perfulandia.clients;

import cl.perfulandia.model.dto.VentaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-venta-db", url = "http://localhost:8084")
public interface VentaDbClient {
    @GetMapping("/ventas")
    List<VentaDTO> findAll();

    @GetMapping("/ventas/{id}")
    VentaDTO findById(@PathVariable("id") Long id);

    @PostMapping("/ventas")
    VentaDTO save(@RequestBody VentaDTO venta);

    @DeleteMapping("/ventas/{id}")
    void deleteById(@PathVariable("id") Long id);
}