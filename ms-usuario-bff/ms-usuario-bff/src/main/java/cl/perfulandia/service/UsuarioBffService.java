package cl.perfulandia.service;

import cl.perfulandia.clients.UsuarioBsClient;
import cl.perfulandia.model.dto.UsuarioDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioBffService {
    private final UsuarioBsClient usuarioBsClient;

    public UsuarioBffService(UsuarioBsClient usuarioBsClient) {
        this.usuarioBsClient = usuarioBsClient;
    }

    public List<UsuarioDTO> findAll() {
        return usuarioBsClient.findAll();
    }

    public UsuarioDTO findById(Long id) {
        return usuarioBsClient.findById(id);
    }

    public UsuarioDTO save(UsuarioDTO usuario) {
        return usuarioBsClient.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioBsClient.deleteById(id);
    }
}