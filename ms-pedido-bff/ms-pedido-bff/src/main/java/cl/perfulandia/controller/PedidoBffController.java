package cl.perfulandia.controller;

import cl.perfulandia.model.dto.PedidoDTO;
import cl.perfulandia.service.PedidoBffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bff/pedidos")
public class PedidoBffController {
    private final PedidoBffService pedidoBffService;

    public PedidoBffController(PedidoBffService pedidoBffService) {
        this.pedidoBffService = pedidoBffService;
    }

    @GetMapping
    public List<PedidoDTO> findAll() {
        return pedidoBffService.findAll();
    }

    @GetMapping("/{id}")
    public PedidoDTO findById(@PathVariable Long id) {
        return pedidoBffService.findById(id);
    }

    @PostMapping
    public PedidoDTO save(@RequestBody PedidoDTO pedido) {
        return pedidoBffService.save(pedido);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        pedidoBffService.deleteById(id);
    }
}