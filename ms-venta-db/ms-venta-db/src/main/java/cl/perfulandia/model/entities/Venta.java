package cl.perfulandia.model.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "venta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "catalogo_id")
    private Long catalogoId;

    @Column(name = "cantidad")
    private Integer cantidad;

    @Column(name = "total")
    private Integer total;

    @Column(name = "fecha")
    private String fecha;
}