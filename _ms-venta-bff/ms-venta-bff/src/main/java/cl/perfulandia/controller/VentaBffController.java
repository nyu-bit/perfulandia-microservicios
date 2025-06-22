package cl.perfulandia.controller;

import cl.perfulandia.model.dto.VentaDTO;
import cl.perfulandia.service.VentaBffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bff/ventas")
public class VentaBffController {
    private final VentaBffService ventaBffService;

    public VentaBffController(VentaBffService ventaBffService) {
        this.ventaBffService = ventaBffService;
    }

    @GetMapping
    public List<VentaDTO> findAll() {
        return ventaBffService.findAll();
    }

    @GetMapping("/{id}")
    public VentaDTO findById(@PathVariable Long id) {
        return ventaBffService.findById(id);
    }

    @PostMapping
    public VentaDTO save(@RequestBody VentaDTO venta) {
        return ventaBffService.save(venta);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        ventaBffService.deleteById(id);
    }
}