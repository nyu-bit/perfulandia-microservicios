package cl.perfulandia.clients;


import cl.perfulandia.model.dto.CatalogoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "ms-catalogo-db", url = "http://localhost:8082")
public interface CatalogoDbClient {
    @GetMapping("/catalogos")
    List<CatalogoDTO> findAll();

    @GetMapping("/catalogos/{id}")
    Optional<CatalogoDTO> findById(@PathVariable("id") Long id);

    @PostMapping("/catalogos")
    CatalogoDTO save(@RequestBody CatalogoDTO catalogo);

    @DeleteMapping("/catalogos/{id}")
    void deleteById(@PathVariable("id") Long id);
}