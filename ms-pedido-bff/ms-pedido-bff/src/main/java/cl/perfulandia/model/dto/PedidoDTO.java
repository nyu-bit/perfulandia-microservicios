package cl.perfulandia.model.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoDTO {
    private Long id;
    private Long clienteId;
    private Long productoId;
    private Integer cantidad;
    private String estado;
}
