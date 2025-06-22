package cl.perfulandia.clients;

import cl.perfulandia.model.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ms-usuario-bs", url = "http://localhost:8081")
public interface UsuarioBsClient {
    @GetMapping("/api/usuarios")
    List<UsuarioDTO> findAll();

    @GetMapping("/api/usuarios/{id}")
    UsuarioDTO findById(@PathVariable("id") Long id);

    @PostMapping("/api/usuarios")
    UsuarioDTO save(@RequestBody UsuarioDTO usuario);

    @DeleteMapping("/api/usuarios/{id}")
    void deleteById(@PathVariable("id") Long id);
}