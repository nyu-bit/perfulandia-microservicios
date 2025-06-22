package cl.perfulandia.clients;

import cl.perfulandia.model.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "usuario-db", url = "http://localhost:8080/usuarios")
public interface UsuarioDbClient {

    @GetMapping
    List<UsuarioDTO> findAll();

    @GetMapping("/{id}")
    UsuarioDTO findById(@PathVariable("id") Long id);

    @PostMapping
    UsuarioDTO save(@RequestBody UsuarioDTO dto);

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Long id);

    @GetMapping("/existe/{id}")
    Boolean existe(@PathVariable("id") Long id);
}
