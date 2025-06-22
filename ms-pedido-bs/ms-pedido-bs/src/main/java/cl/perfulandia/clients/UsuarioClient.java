package cl.perfulandia.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import cl.perfulandia.model.dto.UsuarioDTO;

@FeignClient(name = "ms-usuario-bs", url = "http://localhost:8081")
public interface UsuarioClient {
    @GetMapping("/api/usuarios/{id}")
    UsuarioDTO obtener(@PathVariable("id") Long id);
}