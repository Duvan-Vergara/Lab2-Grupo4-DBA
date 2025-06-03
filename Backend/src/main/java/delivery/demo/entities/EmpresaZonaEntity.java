package delivery.demo.entities;


public class EmpresaZonaEntity {
    private Long id_empresa_zona;
    private Long id_empresa_asociada;
    private Long id_zona;

    public EmpresaZonaEntity() {
    }

    public EmpresaZonaEntity(Long id_empresa_zona, Long id_empresa_asociada, Long id_zona) {
        this.id_empresa_zona = id_empresa_zona;
        this.id_empresa_asociada = id_empresa_asociada;
        this.id_zona = id_zona;
    }

    public EmpresaZonaEntity(Long id_empresa_asociada, Long id_zona) {
        this.id_empresa_asociada = id_empresa_asociada;
        this.id_zona = id_zona;
    }

    public Long getId_empresa_zona() {
        return id_empresa_zona;
    }

    public void setId_empresa_zona(Long id_empresa_zona) {
        this.id_empresa_zona = id_empresa_zona;
    }

    public Long getId_empresa_asociada() {
        return id_empresa_asociada;
    }

    public void setId_empresa_asociada(Long id_empresa_asociada) {
        this.id_empresa_asociada = id_empresa_asociada;
    }

    public Long getId_zona() {
        return id_zona;
    }

    public void setId_zona(Long id_zona) {
        this.id_zona = id_zona;
    }
}
