package cl.perfulandia.clients;

import cl.perfulandia.model.dto.CatalogoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "ms-catalogo-bs", url = "http://localhost:8083")
public interface CatalogoClient {

    @GetMapping("/catalogos")
    List<CatalogoDTO> getAll();

    @GetMapping("/catalogos/{id}")
    CatalogoDTO getById(@PathVariable("id") Long id);

    @PostMapping("/catalogos")
    CatalogoDTO create(@RequestBody CatalogoDTO catalogoDTO);   
}