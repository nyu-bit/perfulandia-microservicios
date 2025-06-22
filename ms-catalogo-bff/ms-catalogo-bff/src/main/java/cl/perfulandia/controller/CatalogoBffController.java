package cl.perfulandia.controller;

import cl.perfulandia.model.dto.CatalogoDTO;
import cl.perfulandia.service.CatalogoBffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bff/catalogos")
public class CatalogoBffController {
    private final CatalogoBffService catalogoBffService;

    public CatalogoBffController(CatalogoBffService catalogoBffService) {
        this.catalogoBffService = catalogoBffService;
    }

    @GetMapping
    public List<CatalogoDTO> findAll() {
        return catalogoBffService.findAll();
    }

    @GetMapping("/{id}")
    public CatalogoDTO findById(@PathVariable Long id) {
        return catalogoBffService.findById(id);
    }

    @PostMapping
    public CatalogoDTO save(@RequestBody CatalogoDTO catalogo) {
        return catalogoBffService.save(catalogo);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        catalogoBffService.deleteById(id);
    }
}