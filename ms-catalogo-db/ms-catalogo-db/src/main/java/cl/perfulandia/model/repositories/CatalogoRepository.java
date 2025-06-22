package cl.perfulandia.model.repositories;

import cl.perfulandia.model.entities.Catalogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogoRepository extends JpaRepository<Catalogo, Long> {
    boolean existsById(Long id);
}
