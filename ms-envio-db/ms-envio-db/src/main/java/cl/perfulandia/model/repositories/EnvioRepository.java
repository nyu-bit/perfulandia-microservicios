package cl.perfulandia.model.repositories;

import cl.perfulandia.model.entities.Envio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnvioRepository extends JpaRepository<Envio, Long> {
}