package cl.perfulandia.controller;

import cl.perfulandia.model.dto.PedidoDTO;
import cl.perfulandia.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<PedidoDTO> findAll() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public PedidoDTO findById(@PathVariable Long id) {
        return pedidoService.findById(id);
    }

    @PostMapping
    public PedidoDTO save(@RequestBody PedidoDTO pedido) {
        return pedidoService.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        pedidoService.deleteById(id);
    }
}