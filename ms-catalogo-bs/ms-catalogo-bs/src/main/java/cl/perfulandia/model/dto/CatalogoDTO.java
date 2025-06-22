package cl.perfulandia.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CatalogoDTO {
    private Long id;
    private String nombre;
    private Integer precio;
    private Integer stock;
}