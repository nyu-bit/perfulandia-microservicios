package cl.perfulandia.service;

import cl.perfulandia.model.dto.EnvioDTO;
import cl.perfulandia.model.entities.Envio;
import cl.perfulandia.model.repositories.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnvioService {
    private final EnvioRepository envioRepository;

    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    public List<EnvioDTO> findAll() {
        return envioRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public EnvioDTO save(EnvioDTO envioDTO) {
        Envio envio = toEntity(envioDTO);
        Envio savedEnvio = envioRepository.save(envio);
        return toDTO(savedEnvio);
    }

    public void deleteById(Long id) {
        envioRepository.deleteById(id);
    }

    public EnvioDTO findById(Long id) {
        return envioRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    private EnvioDTO toDTO(Envio envio) {
        EnvioDTO dto = new EnvioDTO();
        dto.setId(envio.getId());
        dto.setPedidoId(envio.getPedidoId());
        dto.setDireccion(envio.getDireccion());
        dto.setEstado(envio.getEstado());
        dto.setFechaEnvio(envio.getFechaEnvio());
        return dto;
    }

    private Envio toEntity(EnvioDTO dto) {
        Envio envio = new Envio();
        envio.setId(dto.getId());
        envio.setPedidoId(dto.getPedidoId());
        envio.setDireccion(dto.getDireccion());
        envio.setEstado(dto.getEstado());
        envio.setFechaEnvio(dto.getFechaEnvio());
        return envio;
    }
}