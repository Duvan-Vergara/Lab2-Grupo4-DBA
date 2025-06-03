package delivery.demo.entities;

import java.time.LocalDate;



public class ProductoServicioEntity {
    private Long id_producto_servicio;

    private int stock;
    private float precio;
    private Long id_categoria;
    private Long id_empresa_asociada;
    private Boolean es_producto;
    private LocalDate deleted_at;

    public ProductoServicioEntity() {
    }

    public ProductoServicioEntity(Long id_producto_servicio, int stock, float precio, Long id_categoria, Long id_empresa_asociada, Boolean es_producto, LocalDate deleted_at) {
        this.id_producto_servicio = id_producto_servicio;
        this.stock = stock;
        this.precio = precio;
        this.id_categoria = id_categoria;
        this.id_empresa_asociada = id_empresa_asociada;
        this.es_producto = es_producto;
        this.deleted_at = deleted_at;
    }

    public ProductoServicioEntity(int stock, float precio, Long id_categoria, Long id_empresa_asociada, Boolean es_producto, LocalDate deleted_at) {
        this.stock = stock;
        this.precio = precio;
        this.id_categoria = id_categoria;
        this.id_empresa_asociada = id_empresa_asociada;
        this.es_producto = es_producto;
        this.deleted_at = deleted_at;
    }

    public Long getId_producto_servicio() {
        return id_producto_servicio;
    }

    public void setId_producto_servicio(Long id_producto_servicio) {
        this.id_producto_servicio = id_producto_servicio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Long getId_empresa_asociada() {
        return id_empresa_asociada;
    }

    public void setId_empresa_asociada(Long id_empresa_asociada) {
        this.id_empresa_asociada = id_empresa_asociada;
    }

    public Boolean getEs_producto() {
        return es_producto;
    }

    public void setEs_producto(Boolean es_producto) {
        this.es_producto = es_producto;
    }

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }
}
