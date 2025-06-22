package cl.perfulandia.model.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "envio")
public class Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "pedido_id", nullable = false)
    private Long pedidoId;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String estado; // EJ: PENDIENTE, ENVIADO, ENTREGADO

    @Column(name = "fecha_envio")
    private LocalDate fechaEnvio;

}
