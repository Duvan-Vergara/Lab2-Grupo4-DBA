package delivery.demo.entities;

import java.sql.Date;
import java.time.LocalDate;
import org.locationtech.jts.geom.*;


public class PedidoEntity {

    private Long id_pedido;

    private Date hora_pedido;
    private Long id_urgencia;
    private Long id_detalle_pedido;
    private Long id_repartidor;
    private Long id_cliente;
    private Long id_medio_pago;
    private LocalDate deleted_at;
    private Point ubicacion_entrega;
    private LineString ruta_estimada;

    public PedidoEntity() {
    }

    public PedidoEntity(Long id_pedido, Date hora_pedido, Long id_urgencia, Long id_detalle_pedido, Long id_repartidor, Long id_cliente, Long id_medio_pago, LocalDate deleted_at, Point ubicacion_entrega, LineString ruta_estimada) {
        this.id_pedido = id_pedido;
        this.hora_pedido = hora_pedido;
        this.id_urgencia = id_urgencia;
        this.id_detalle_pedido = id_detalle_pedido;
        this.id_repartidor = id_repartidor;
        this.id_cliente = id_cliente;
        this.id_medio_pago = id_medio_pago;
        this.deleted_at = deleted_at;
        this.ubicacion_entrega = ubicacion_entrega;
        this.ruta_estimada = ruta_estimada;
    }

    public PedidoEntity(Date hora_pedido, Long id_urgencia, Long id_detalle_pedido, Long id_repartidor, Long id_cliente, Long id_medio_pago, LocalDate deleted_at, Point ubicacion_entrega, LineString ruta_estimada) {
        this.hora_pedido = hora_pedido;
        this.id_urgencia = id_urgencia;
        this.id_detalle_pedido = id_detalle_pedido;
        this.id_repartidor = id_repartidor;
        this.id_cliente = id_cliente;
        this.id_medio_pago = id_medio_pago;
        this.deleted_at = deleted_at;
        this.ubicacion_entrega = ubicacion_entrega;
        this.ruta_estimada = ruta_estimada;
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Date getHora_pedido() {
        return hora_pedido;
    }

    public void setHora_pedido(Date hora_pedido) {
        this.hora_pedido = hora_pedido;
    }

    public Long getId_urgencia() {
        return id_urgencia;
    }

    public void setId_urgencia(Long id_urgencia) {
        this.id_urgencia = id_urgencia;
    }

    public Long getId_detalle_pedido() {
        return id_detalle_pedido;
    }

    public void setId_detalle_pedido(Long id_detalle_pedido) {
        this.id_detalle_pedido = id_detalle_pedido;
    }

    public Long getId_repartidor() {
        return id_repartidor;
    }

    public void setId_repartidor(Long id_repartidor) {
        this.id_repartidor = id_repartidor;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Long getId_medio_pago() {
        return id_medio_pago;
    }

    public void setId_medio_pago(Long id_medio_pago) {
        this.id_medio_pago = id_medio_pago;
    }

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Point getUbicacion_entrega() {
        return ubicacion_entrega;
    }

    public void setUbicacion_entrega(Point ubicacion_entrega) {
        this.ubicacion_entrega = ubicacion_entrega;
    }

    public LineString getRuta_estimada() {
        return ruta_estimada;
    }

    public void setRuta_estimada(LineString ruta_estimada) {
        this.ruta_estimada = ruta_estimada;
    }
}
