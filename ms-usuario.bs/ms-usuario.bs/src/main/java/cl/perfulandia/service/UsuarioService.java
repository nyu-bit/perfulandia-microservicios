package cl.perfulandia.service;

import cl.perfulandia.clients.UsuarioDbClient;
import cl.perfulandia.model.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioDbClient dbClient;

    public List<UsuarioDTO> listar() {
        return dbClient.findAll();
    }

    public UsuarioDTO obtenerPorId(Long id) {
        return dbClient.findById(id);
    }

    public UsuarioDTO crear(UsuarioDTO dto) {
        if (dto.getNombre() == null || dto.getCorreo() == null) {
            throw new IllegalArgumentException("Nombre y correo son obligatorios");
        }
        return dbClient.save(dto);
    }

    public void eliminar(Long id) {
        dbClient.delete(id);
    }

    public boolean existeUsuario(Long id) {
        return dbClient.existe(id);
    }
}
