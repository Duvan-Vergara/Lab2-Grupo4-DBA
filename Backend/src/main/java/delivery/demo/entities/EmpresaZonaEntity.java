package delivery.demo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaZonaEntity {
    private Long id_empresa_zona;
    private Long id_empresa_asociada;
    private Long id_zona;
}
