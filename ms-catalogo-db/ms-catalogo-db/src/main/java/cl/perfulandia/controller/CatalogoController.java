package cl.perfulandia.controller;

import cl.perfulandia.model.dto.CatalogoDTO;
import cl.perfulandia.model.entities.Catalogo;
import cl.perfulandia.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalogos")
public class CatalogoController {

    @Autowired
    private CatalogoService catalogoService;

    private CatalogoDTO toDTO(Catalogo catalogo) {
        return new CatalogoDTO(
            catalogo.getId(),
            catalogo.getNombre(),
            catalogo.getPrecio(),
            catalogo.getStock()
        );
    }

    private Catalogo toEntity(CatalogoDTO dto) {
        return new Catalogo(
            dto.getId(),
            dto.getNombre(),
            dto.getPrecio(),
            dto.getStock()
        );
    }

    @GetMapping
    public ResponseEntity<List<CatalogoDTO>> getAll() {
        List<CatalogoDTO> lista = catalogoService.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatalogoDTO> getById(@PathVariable Long id) {
        Optional<Catalogo> catalogoOpt = catalogoService.findById(id);
        return catalogoOpt
            .map(this::toDTO)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CatalogoDTO> create(@RequestBody CatalogoDTO catalogoDTO) {
        Catalogo catalogo = toEntity(catalogoDTO);
        CatalogoDTO saved = toDTO(catalogoService.save(catalogo));
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        catalogoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}