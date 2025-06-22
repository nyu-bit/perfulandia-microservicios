package cl.perfulandia.service;

import cl.perfulandia.model.dto.UsuarioDTO;
import cl.perfulandia.model.entities.Usuario;
import cl.perfulandia.model.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public List<UsuarioDTO> listar() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public UsuarioDTO obtenerPorId(Long id) {
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.map(this::toDTO).orElse(null);
    }

    public UsuarioDTO guardar(UsuarioDTO dto) {
        return toDTO(repository.save(toEntity(dto)));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    public boolean existeUsuario(Long id) {
        return repository.existsById(id);
    }

    private UsuarioDTO toDTO(Usuario u) {
        return new UsuarioDTO(u.getId(), u.getNombre(), u.getCorreo(), u.isActivo());
    }

    private Usuario toEntity(UsuarioDTO dto) {
        return new Usuario(dto.getId(), dto.getNombre(), dto.getCorreo(), dto.isActivo());
    }
}
