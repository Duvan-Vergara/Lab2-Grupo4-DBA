package delivery.demo.entities;

import org.locationtech.jts.geom.Polygon;

public class ZonaCoberturaEntity {
    private Long id_zona;
    private String nombre;
    private String tipo;
    private Polygon zona_geom;

    public ZonaCoberturaEntity() {
    }

    public ZonaCoberturaEntity(Long id_zona, String nombre, String tipo, Polygon zona_geom) {
        this.id_zona = id_zona;
        this.nombre = nombre;
        this.tipo = tipo;
        this.zona_geom = zona_geom;
    }

    public ZonaCoberturaEntity(String nombre, String tipo, Polygon zona_geom) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.zona_geom = zona_geom;
    }

    public Long getId_zona() {
        return id_zona;
    }

    public void setId_zona(Long id_zona) {
        this.id_zona = id_zona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Polygon getZona_geom() {
        return zona_geom;
    }

    public void setZona_geom(Polygon zona_geom) {
        this.zona_geom = zona_geom;
    }
}
