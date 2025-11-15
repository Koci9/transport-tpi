package utnfrc.isi.back.tpi.common.dto;

import java.math.BigDecimal;

public class SolicitudDto {
    private Long id;
    private ClienteDto cliente;
    private ContenedorDto contenedor;
    private BigDecimal costoEstimado;
    private Double tiempoEstimado;
    private BigDecimal costoFinal;
    private Double tiempoReal;
    private String estado;

    public SolicitudDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public ContenedorDto getContenedor() {
        return contenedor;
    }

    public void setContenedor(ContenedorDto contenedor) {
        this.contenedor = contenedor;
    }

    public BigDecimal getCostoEstimado() {
        return costoEstimado;
    }

    public void setCostoEstimado(BigDecimal costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    public Double getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(Double tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public BigDecimal getCostoFinal() {
        return costoFinal;
    }

    public void setCostoFinal(BigDecimal costoFinal) {
        this.costoFinal = costoFinal;
    }

    public Double getTiempoReal() {
        return tiempoReal;
    }

    public void setTiempoReal(Double tiempoReal) {
        this.tiempoReal = tiempoReal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}