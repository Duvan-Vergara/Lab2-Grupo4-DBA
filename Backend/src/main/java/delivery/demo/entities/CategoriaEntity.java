package delivery.demo.entities;

import java.time.LocalDate;

public class CategoriaEntity {

    private Long id_categoria;

    private String nombre;
    private LocalDate deleted_at;

    public CategoriaEntity() {
    }

    public CategoriaEntity(Long id_categoria, String nombre, LocalDate deleted_at) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.deleted_at = deleted_at;
    }

    public CategoriaEntity(String nombre, LocalDate deleted_at) {
        this.nombre = nombre;
        this.deleted_at = deleted_at;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
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
}
