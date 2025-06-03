package delivery.demo.entities;

import java.time.LocalDate;

public class UrgenciaEntity {
    private Long id_urgencia;

    private String tipo;
    private LocalDate deleted_at;

    public UrgenciaEntity() {
    }

    public UrgenciaEntity(Long id_urgencia, String tipo, LocalDate deleted_at) {
        this.id_urgencia = id_urgencia;
        this.tipo = tipo;
        this.deleted_at = deleted_at;
    }

    public UrgenciaEntity(String tipo, LocalDate deleted_at) {
        this.tipo = tipo;
        this.deleted_at = deleted_at;
    }

    public Long getId_urgencia() {
        return id_urgencia;
    }

    public void setId_urgencia(Long id_urgencia) {
        this.id_urgencia = id_urgencia;
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
