package cl.perfulandia.clients;

import cl.perfulandia.model.dto.CatalogoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-catalogo-bs", url = "http://localhost:8083")
public interface CatalogoBsClient {
    @GetMapping("/catalogos")
    List<CatalogoDTO> findAll();

    @GetMapping("/catalogos/{id}")
    CatalogoDTO findById(@PathVariable("id") Long id);

    @PostMapping("/catalogos")
    CatalogoDTO save(@RequestBody CatalogoDTO catalogo);

    @DeleteMapping("/catalogos/{id}")
    void deleteById(@PathVariable("id") Long id);
}