package cl.perfulandia.service;

import cl.perfulandia.clients.CatalogoDbClient;
import cl.perfulandia.model.dto.CatalogoDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoService {

    @Autowired
    private CatalogoDbClient catalogoDbClient;

    public List<CatalogoDTO> findAll() {
        return catalogoDbClient.findAll();
    }

    public Optional<CatalogoDTO> findById(Long id) {
        return catalogoDbClient.findById(id);
    }

    public CatalogoDTO save(CatalogoDTO catalogo) {
        return catalogoDbClient.save(catalogo);
    }

    public void deleteById(Long id) {
        catalogoDbClient.deleteById(id);
    }
}