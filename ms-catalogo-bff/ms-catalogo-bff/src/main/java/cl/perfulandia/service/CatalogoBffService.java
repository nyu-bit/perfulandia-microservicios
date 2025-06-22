package cl.perfulandia.service;

import cl.perfulandia.clients.CatalogoBsClient;
import cl.perfulandia.model.dto.CatalogoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogoBffService {
    private final CatalogoBsClient catalogoBsClient;

    public CatalogoBffService(CatalogoBsClient catalogoBsClient) {
        this.catalogoBsClient = catalogoBsClient;
    }

    public List<CatalogoDTO> findAll() {
        return catalogoBsClient.findAll();
    }

    public CatalogoDTO findById(Long id) {
        return catalogoBsClient.findById(id);
    }

    public CatalogoDTO save(CatalogoDTO catalogo) {
        return catalogoBsClient.save(catalogo);
    }

    public void deleteById(Long id) {
        catalogoBsClient.deleteById(id);
    }
}