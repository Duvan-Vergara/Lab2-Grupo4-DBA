package delivery.demo.entities;

import java.time.LocalDate;

public class PedidoProductoEntity {

    private Long id_pedido;
    private Long id_producto_servicio;
    private int cantidad;
    private LocalDate deleted_at;

    public PedidoProductoEntity() {
    }

    public PedidoProductoEntity(Long id_pedido, Long id_producto_servicio, int cantidad, LocalDate deleted_at) {
        this.id_pedido = id_pedido;
        this.id_producto_servicio = id_producto_servicio;
        this.cantidad = cantidad;
        this.deleted_at = deleted_at;
    }

    public PedidoProductoEntity(Long id_producto_servicio, int cantidad, LocalDate deleted_at) {
        this.id_producto_servicio = id_producto_servicio;
        this.cantidad = cantidad;
        this.deleted_at = deleted_at;
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Long getId_producto_servicio() {
        return id_producto_servicio;
    }

    public void setId_producto_servicio(Long id_producto_servicio) {
        this.id_producto_servicio = id_producto_servicio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }
}
