package cl.perfulandia.controller;

import cl.perfulandia.model.entities.Catalogo;
import cl.perfulandia.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/catalogos")
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

    @GetMapping
    public List<Catalogo> getAll() {
        return catalogoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Catalogo> getById(@PathVariable Long id) {
        return catalogoService.findById(id);
    }

    @PostMapping
    public Catalogo create(@RequestBody Catalogo catalogo) {
        return catalogoService.save(catalogo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        catalogoService.deleteById(id);
    }
}