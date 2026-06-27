package cl.duoc.api_auditoria.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "AUDITORIA")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "COMPONENTE_ID", nullable = false)
    private Long componenteId;

    @Column(name = "ESTADO_INICIAL")
    private String estadoInicial;

    @Column(name = "ESTADO_DESPUES", nullable = false)
    private String estadoDespues;

    @Column(name = "UNIDAD_INICIAL")
    private Integer unidadInicial;

    @Column(name = "UNIDAD_DESPUES")
    private Integer unidadDespues;

    @Column(name = "FECHA_REGISTRO")
    private LocalDateTime fechaRegistro;

    @PrePersist
    public void prePersist() {
        this.fechaRegistro = LocalDateTime.now();
    }

    // GETTERS Y SETTERS

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getComponenteId() { return componenteId; }
    public void setComponenteId(Long componenteId) { this.componenteId = componenteId; }

    public String getEstadoInicial() { return estadoInicial; }
    public void setEstadoInicial(String estadoInicial) { this.estadoInicial = estadoInicial; }

    public String getEstadoDespues() { return estadoDespues; }
    public void setEstadoDespues(String estadoDespues) { this.estadoDespues = estadoDespues; }

    public Integer getUnidadInicial() { return unidadInicial; }
    public void setUnidadInicial(Integer unidadInicial) { this.unidadInicial = unidadInicial; }

    public Integer getUnidadDespues() { return unidadDespues; }
    public void setUnidadDespues(Integer unidadDespues) { this.unidadDespues = unidadDespues; }

    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
}