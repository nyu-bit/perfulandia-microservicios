package cl.perfulandia.controller;

import cl.perfulandia.model.dto.EnvioDTO;
import cl.perfulandia.service.EnvioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios")
public class EnvioController {
    private final EnvioService envioService;

    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public List<EnvioDTO> findAll() {
        return envioService.findAll();
    }

    @GetMapping("/{id}")
    public EnvioDTO findById(@PathVariable Long id) {
        return envioService.findById(id);
    }

    @PostMapping
    public EnvioDTO save(@RequestBody EnvioDTO envio) {
        return envioService.save(envio);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        envioService.deleteById(id);
    }
}