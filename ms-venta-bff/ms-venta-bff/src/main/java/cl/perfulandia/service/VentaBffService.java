package cl.perfulandia.service;

import cl.perfulandia.clients.VentaBsClient;
import cl.perfulandia.model.dto.VentaDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaBffService {
    private final VentaBsClient ventaBsClient;

    public VentaBffService(VentaBsClient ventaBsClient) {
        this.ventaBsClient = ventaBsClient;
    }

    public List<VentaDTO> findAll() {
        return ventaBsClient.findAll();
    }

    public VentaDTO findById(Long id) {
        return ventaBsClient.findById(id);
    }

    public VentaDTO save(VentaDTO venta) {
        return ventaBsClient.save(venta);
    }

    public void deleteById(Long id) {
        ventaBsClient.deleteById(id);
    }
}