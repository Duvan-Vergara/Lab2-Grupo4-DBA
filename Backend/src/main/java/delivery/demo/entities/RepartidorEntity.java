package delivery.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepartidorEntity {
    private Long id_repartidor;

    private String nombre;

    private Long id_empresa_asociada;
    private LocalDate deleted_at;
    private Point ubicacion_repartidor;
}
