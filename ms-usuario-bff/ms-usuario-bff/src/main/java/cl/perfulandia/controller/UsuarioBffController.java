package cl.perfulandia.controller;

import cl.perfulandia.model.dto.UsuarioDTO;
import cl.perfulandia.service.UsuarioBffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bff/usuarios")
public class UsuarioBffController {
    private final UsuarioBffService usuarioBffService;

    public UsuarioBffController(UsuarioBffService usuarioBffService) {
        this.usuarioBffService = usuarioBffService;
    }

    @GetMapping
    public List<UsuarioDTO> findAll() {
        return usuarioBffService.findAll();
    }

    @GetMapping("/{id}")
    public UsuarioDTO findById(@PathVariable Long id) {
        return usuarioBffService.findById(id);
    }

    @PostMapping
    public UsuarioDTO save(@RequestBody UsuarioDTO usuario) {
        return usuarioBffService.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        usuarioBffService.deleteById(id);
    }
}