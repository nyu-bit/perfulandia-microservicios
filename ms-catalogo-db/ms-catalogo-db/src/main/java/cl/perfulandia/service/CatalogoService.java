package cl.perfulandia.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.perfulandia.model.entities.Catalogo;
import cl.perfulandia.model.repositories.CatalogoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CatalogoService {

    @Autowired
    private CatalogoRepository catalogoRepository;

    public List<Catalogo> findAll() {
        return catalogoRepository.findAll();
    }

    public Optional<Catalogo> findById(Long id) {
        return catalogoRepository.findById(id);
    }

    public Catalogo save(Catalogo catalogo) {
        return catalogoRepository.save(catalogo);
    }

    public void deleteById(Long id) {
        catalogoRepository.deleteById(id);
    }
}