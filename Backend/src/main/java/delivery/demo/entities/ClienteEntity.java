package delivery.demo.entities;

import jakarta.validation.constraints.Email;
import org.locationtech.jts.geom.Point;

import java.time.LocalDate;

public class ClienteEntity {

    private Long id_cliente;
    private String nombre;
    private String direccion;

    @Email
    private String correo;

    private String password;

    private LocalDate deleted_at;
    private Point ubicacion_cliente;

    public ClienteEntity() {
    }

    public ClienteEntity(Long id_cliente, String nombre, String direccion, String correo, String password, LocalDate deleted_at, Point ubicacion_cliente) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.password = password;
        this.deleted_at = deleted_at;
        this.ubicacion_cliente = ubicacion_cliente;
    }

    public ClienteEntity(String nombre, String direccion, String correo, String password, LocalDate deleted_at, Point ubicacion_cliente) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
        this.password = password;
        this.deleted_at = deleted_at;
        this.ubicacion_cliente = ubicacion_cliente;
    }

    public Long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }

    public Point getUbicacion_cliente() {
        return ubicacion_cliente;
    }

    public void setUbicacion_cliente(Point ubicacion_cliente) {
        this.ubicacion_cliente = ubicacion_cliente;
    }
}
