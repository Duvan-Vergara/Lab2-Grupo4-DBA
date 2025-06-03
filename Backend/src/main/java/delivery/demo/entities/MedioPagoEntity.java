package delivery.demo.entities;

import java.time.LocalDate;


public class MedioPagoEntity {
    private Long id_medio_pago;

    private String tipo;
    private LocalDate deleted_at;

    public MedioPagoEntity() {
    }

    public MedioPagoEntity(Long id_medio_pago, String tipo, LocalDate deleted_at) {
        this.id_medio_pago = id_medio_pago;
        this.tipo = tipo;
        this.deleted_at = deleted_at;
    }

    public MedioPagoEntity(String tipo, LocalDate deleted_at) {
        this.tipo = tipo;
        this.deleted_at = deleted_at;
    }

    public Long getId_medio_pago() {
        return id_medio_pago;
    }

    public void setId_medio_pago(Long id_medio_pago) {
        this.id_medio_pago = id_medio_pago;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }
}
