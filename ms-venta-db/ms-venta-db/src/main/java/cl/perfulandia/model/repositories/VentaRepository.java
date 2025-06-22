package cl.perfulandia.model.repositories;

import cl.perfulandia.model.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}