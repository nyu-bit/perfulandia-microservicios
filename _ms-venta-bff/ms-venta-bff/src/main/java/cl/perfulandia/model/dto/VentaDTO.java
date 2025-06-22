package cl.perfulandia.model.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VentaDTO {
    private Long id;
    private Long usuarioId;
    private Long catalogoId;
    private Integer cantidad;
    private Integer total;
    private String fecha;
}