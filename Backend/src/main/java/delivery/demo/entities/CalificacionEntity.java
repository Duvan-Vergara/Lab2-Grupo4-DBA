package delivery.demo.entities;


import java.math.BigDecimal;
import java.time.LocalDate;

public class CalificacionEntity {

    private Integer id_calificacion;   // id_calificacion
    private Integer total_puntos;      // total_puntos
    private Integer total_pedidos;     // total_pedidos
    private BigDecimal promedio;      // promedio (NUMERIC)
    private Integer id_repartidor;     // id_repartidor
    private LocalDate deleted_at;

    public CalificacionEntity() {
    }

    public CalificacionEntity(Integer id_calificacion, Integer total_puntos, Integer total_pedidos, BigDecimal promedio, Integer id_repartidor, LocalDate deleted_at) {
        this.id_calificacion = id_calificacion;
        this.total_puntos = total_puntos;
        this.total_pedidos = total_pedidos;
        this.promedio = promedio;
        this.id_repartidor = id_repartidor;
        this.deleted_at = deleted_at;
    }

    public CalificacionEntity(Integer total_puntos, Integer total_pedidos, BigDecimal promedio, Integer id_repartidor, LocalDate deleted_at) {
        this.total_puntos = total_puntos;
        this.total_pedidos = total_pedidos;
        this.promedio = promedio;
        this.id_repartidor = id_repartidor;
        this.deleted_at = deleted_at;
    }

    public Integer getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(Integer id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public Integer getTotal_puntos() {
        return total_puntos;
    }

    public void setTotal_puntos(Integer total_puntos) {
        this.total_puntos = total_puntos;
    }

    public Integer getTotal_pedidos() {
        return total_pedidos;
    }

    public void setTotal_pedidos(Integer total_pedidos) {
        this.total_pedidos = total_pedidos;
    }

    public BigDecimal getPromedio() {
        return promedio;
    }

    public void setPromedio(BigDecimal promedio) {
        this.promedio = promedio;
    }

    public Integer getId_repartidor() {
        return id_repartidor;
    }

    public void setId_repartidor(Integer id_repartidor) {
        this.id_repartidor = id_repartidor;
    }

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }
}
