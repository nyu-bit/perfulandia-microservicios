package cl.perfulandia.model.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class EnvioDTO {
    private Long id;
    private Long pedidoId;
    private String direccion;
    private String estado;
    private LocalDate fechaEnvio;
}