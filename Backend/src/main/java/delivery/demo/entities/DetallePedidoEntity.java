package delivery.demo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetallePedidoEntity {

    private Long id_detalle_pedido;

    private boolean entregado;
    private Date hora_entrega;
    private Float calificacion;
    private LocalDate deleted_at;
}
