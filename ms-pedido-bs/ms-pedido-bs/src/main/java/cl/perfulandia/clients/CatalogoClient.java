package cl.perfulandia.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import cl.perfulandia.model.dto.CatalogoDTO;

@FeignClient(name = "ms-catalogo-bs", url = "http://localhost:8083")
public interface CatalogoClient {
    @GetMapping("/catalogos/{id}")
    CatalogoDTO getById(@PathVariable("id") Long id);
}