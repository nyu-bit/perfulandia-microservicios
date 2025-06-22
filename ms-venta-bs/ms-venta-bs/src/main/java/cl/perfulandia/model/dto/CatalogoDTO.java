package cl.perfulandia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoDTO {
    private Long id;
    private String nombre;
    private Integer precio;
    private Integer stock;
}
