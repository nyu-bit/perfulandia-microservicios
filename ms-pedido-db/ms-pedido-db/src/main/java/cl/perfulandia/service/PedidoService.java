package cl.perfulandia.service;

import cl.perfulandia.model.dto.PedidoDTO;
import cl.perfulandia.model.entities.Pedido;
import cl.perfulandia.model.repositories.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService {
    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public List<PedidoDTO> findAll() {
        return pedidoRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public PedidoDTO save(PedidoDTO pedidoDTO) {
        Pedido pedido = toEntity(pedidoDTO);
        Pedido savedPedido = pedidoRepository.save(pedido);
        return toDTO(savedPedido);
    }

    public void deleteById(Long id) {
        pedidoRepository.deleteById(id);
    }

    public PedidoDTO findById(Long id) {
        return pedidoRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    private PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setClienteId(pedido.getClienteId());
        dto.setProductoId(pedido.getProductoId());
        dto.setCantidad(pedido.getCantidad());
        dto.setEstado(pedido.getEstado());
        return dto;
    }

    private Pedido toEntity(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setId(dto.getId());
        pedido.setClienteId(dto.getClienteId());
        pedido.setProductoId(dto.getProductoId());
        pedido.setCantidad(dto.getCantidad());
        pedido.setEstado(dto.getEstado());
        return pedido;
    }
}