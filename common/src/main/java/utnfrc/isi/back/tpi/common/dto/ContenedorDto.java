package utnfrc.isi.back.tpi.common.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ContenedorDto {
    private Long id;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal peso;

    @NotNull
    @DecimalMin("0.01")
    private BigDecimal volumen;

    private String estado;

    public ContenedorDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public BigDecimal getVolumen() {
        return volumen;
    }

    public void setVolumen(BigDecimal volumen) {
        this.volumen = volumen;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}