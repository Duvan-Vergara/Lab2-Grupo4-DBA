package delivery.demo.entities;

import java.sql.Date;
import java.time.LocalDate;

public class DetallePedidoEntity {

    private Long id_detalle_pedido;

    private boolean entregado;
    private Date hora_entrega;
    private Float calificacion;
    private LocalDate deleted_at;

    public DetallePedidoEntity() {
    }

    public DetallePedidoEntity(Long id_detalle_pedido, boolean entregado, Date hora_entrega, Float calificacion, LocalDate deleted_at) {
        this.id_detalle_pedido = id_detalle_pedido;
        this.entregado = entregado;
        this.hora_entrega = hora_entrega;
        this.calificacion = calificacion;
        this.deleted_at = deleted_at;
    }

    public DetallePedidoEntity(boolean entregado, Date hora_entrega, Float calificacion, LocalDate deleted_at) {
        this.entregado = entregado;
        this.hora_entrega = hora_entrega;
        this.calificacion = calificacion;
        this.deleted_at = deleted_at;
    }

    public Long getId_detalle_pedido() {
        return id_detalle_pedido;
    }

    public void setId_detalle_pedido(Long id_detalle_pedido) {
        this.id_detalle_pedido = id_detalle_pedido;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public Date getHora_entrega() {
        return hora_entrega;
    }

    public void setHora_entrega(Date hora_entrega) {
        this.hora_entrega = hora_entrega;
    }

    public Float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(Float calificacion) {
        this.calificacion = calificacion;
    }

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }
}
