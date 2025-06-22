package cl.perfulandia.service;

import cl.perfulandia.model.entities.Envio;
import cl.perfulandia.model.repositories.EnvioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {
    private final EnvioRepository envioRepository;

    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    public List<Envio> findAll() {
        return envioRepository.findAll();
    }

    public Envio save(Envio envio) {
        return envioRepository.save(envio);
    }

    public void deleteById(Long id) {
        envioRepository.deleteById(id);
    }

    public Envio findById(Long id) {
        return envioRepository.findById(id).orElse(null);
    }
}