package delivery.demo.entities;


import org.locationtech.jts.geom.Point;
import java.time.LocalDate;

public class EmpresaAsociadaEntity {
    private Long id_empresa_asociada;

    private String nombre;
    private LocalDate deleted_at;
    private Point ubicacion_empresa_asociada;

    public EmpresaAsociadaEntity() {
    }

    public EmpresaAsociadaEntity(Long id_empresa_asociada, String nombre, LocalDate deleted_at, Point ubicacion_empresa_asociada) {
        this.id_empresa_asociada = id_empresa_asociada;
        this.nombre = nombre;
        this.deleted_at = deleted_at;
        this.ubicacion_empresa_asociada = ubicacion_empresa_asociada;
    }

    public EmpresaAsociadaEntity(String nombre, LocalDate deleted_at, Point ubicacion_empresa_asociada) {
        this.nombre = nombre;
        this.deleted_at = deleted_at;
        this.ubicacion_empresa_asociada = ubicacion_empresa_asociada;
    }

    public Long getId_empresa_asociada() {
        return id_empresa_asociada;
    }

    public void setId_empresa_asociada(Long id_empresa_asociada) {
        this.id_empresa_asociada = id_empresa_asociada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Point getUbicacion_empresa_asociada() {
        return ubicacion_empresa_asociada;
    }

    public void setUbicacion_empresa_asociada(Point ubicacion_empresa_asociada) {
        this.ubicacion_empresa_asociada = ubicacion_empresa_asociada;
    }
}
