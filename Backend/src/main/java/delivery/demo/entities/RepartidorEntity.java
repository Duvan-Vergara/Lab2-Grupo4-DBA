package delivery.demo.entities;

import org.locationtech.jts.geom.Point;
import java.time.LocalDate;

public class RepartidorEntity {
    private Long id_repartidor;

    private String nombre;

    private Long id_empresa_asociada;
    private LocalDate deleted_at;
    private Point ubicacion_repartidor;
    private double Distancia_recorrida;

    public RepartidorEntity() {
    }

    public RepartidorEntity(Long id_repartidor, String nombre, Long id_empresa_asociada, LocalDate deleted_at, Point ubicacion_repartidor, double distancia_recorrida) {
        this.id_repartidor = id_repartidor;
        this.nombre = nombre;
        this.id_empresa_asociada = id_empresa_asociada;
        this.deleted_at = deleted_at;
        this.ubicacion_repartidor = ubicacion_repartidor;
        Distancia_recorrida = distancia_recorrida;
    }

    public RepartidorEntity(String nombre, Long id_empresa_asociada, LocalDate deleted_at, Point ubicacion_repartidor, double distancia_recorrida) {
        this.nombre = nombre;
        this.id_empresa_asociada = id_empresa_asociada;
        this.deleted_at = deleted_at;
        this.ubicacion_repartidor = ubicacion_repartidor;
        Distancia_recorrida = distancia_recorrida;
    }

    public Long getId_repartidor() {
        return id_repartidor;
    }

    public void setId_repartidor(Long id_repartidor) {
        this.id_repartidor = id_repartidor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId_empresa_asociada() {
        return id_empresa_asociada;
    }

    public void setId_empresa_asociada(Long id_empresa_asociada) {
        this.id_empresa_asociada = id_empresa_asociada;
    }

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Point getUbicacion_repartidor() {
        return ubicacion_repartidor;
    }

    public void setUbicacion_repartidor(Point ubicacion_repartidor) {
        this.ubicacion_repartidor = ubicacion_repartidor;
    }

    public double getDistancia_recorrida() {
        return Distancia_recorrida;
    }

    public void setDistancia_recorrida(double distancia_recorrida) {
        Distancia_recorrida = distancia_recorrida;
    }
}
