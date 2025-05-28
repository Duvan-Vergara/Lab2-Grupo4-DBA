package delivery.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.locationtech.jts.geom.Point;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaAsociadaEntity {
    private Long id_empresa_asociada;

    private String nombre;
    private LocalDate deleted_at;
    private Point ubicacion_empresa_asociada;
}
