package cl.perfulandia.clients;

import cl.perfulandia.model.dto.EnvioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-envio-db", url = "http://localhost:8088")
public interface EnvioDbClient {
    @GetMapping("/envios")
    List<EnvioDTO> findAll();

    @GetMapping("/envios/{id}")
    EnvioDTO findById(@PathVariable("id") Long id);

    @PostMapping("/envios")
    EnvioDTO save(@RequestBody EnvioDTO envio);

    @DeleteMapping("/envios/{id}")
    void deleteById(@PathVariable("id") Long id);
}