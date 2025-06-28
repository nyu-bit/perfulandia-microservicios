package cl.perfulandia.model.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvioDTO {
    private Long id;
    private Long pedidoId;
    private String direccion;
    private String estado;
    private LocalDate fechaEnvio;
}