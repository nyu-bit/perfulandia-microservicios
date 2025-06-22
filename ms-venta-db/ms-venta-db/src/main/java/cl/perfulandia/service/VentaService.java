package cl.perfulandia.service;

import cl.perfulandia.model.dto.VentaDTO;
import cl.perfulandia.model.entities.Venta;
import cl.perfulandia.model.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    private VentaDTO toDTO(Venta venta) {
        return new VentaDTO(
            venta.getId(),
            venta.getUsuarioId(),
            venta.getCatalogoId(),
            venta.getCantidad(),
            venta.getTotal(),
            venta.getFecha()
        );
    }

    private Venta toEntity(VentaDTO dto) {
        return new Venta(
            dto.getId(),
            dto.getUsuarioId(),
            dto.getCatalogoId(),
            dto.getCantidad(),
            dto.getTotal(),
            dto.getFecha()
        );
    }

    public List<VentaDTO> findAll() {
        return ventaRepository.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    public Optional<VentaDTO> findById(Long id) {
        return ventaRepository.findById(id).map(this::toDTO);
    }

    public VentaDTO save(VentaDTO dto) {
        Venta venta = toEntity(dto);
        return toDTO(ventaRepository.save(venta));
    }

    public void deleteById(Long id) {
        ventaRepository.deleteById(id);
    }
}