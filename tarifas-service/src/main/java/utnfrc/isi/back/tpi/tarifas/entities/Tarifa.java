package utnfrc.isi.back.tpi.tarifas.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tarifa")
public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarifa;

    @Column(nullable = false, length = 50)
    private String tipo; // ej: general, refrigerado

    private BigDecimal pesoMinKg;
    private BigDecimal pesoMaxKg;
    private BigDecimal volumenMinM3;
    private BigDecimal volumenMaxM3;

    @Column(nullable = false)
    private BigDecimal costoKmBase;

    @Column(nullable = false)
    private BigDecimal cargoFijoTramo = BigDecimal.ZERO;

    @Column(nullable = false)
    private BigDecimal valorCombustible = BigDecimal.ZERO;

    @Column(nullable = false)
    private Double consumoPromedio = 0.0;

    @Column(nullable = false, length = 20)
    private String estado = "ACTIVA";

    // getters y setters
    public Long getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Long idTarifa) {
        this.idTarifa = idTarifa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPesoMinKg() {
        return pesoMinKg;
    }

    public void setPesoMinKg(BigDecimal pesoMinKg) {
        this.pesoMinKg = pesoMinKg;
    }

    public BigDecimal getPesoMaxKg() {
        return pesoMaxKg;
    }

    public void setPesoMaxKg(BigDecimal pesoMaxKg) {
        this.pesoMaxKg = pesoMaxKg;
    }

    public BigDecimal getVolumenMinM3() {
        return volumenMinM3;
    }

    public void setVolumenMinM3(BigDecimal volumenMinM3) {
        this.volumenMinM3 = volumenMinM3;
    }

    public BigDecimal getVolumenMaxM3() {
        return volumenMaxM3;
    }

    public void setVolumenMaxM3(BigDecimal volumenMaxM3) {
        this.volumenMaxM3 = volumenMaxM3;
    }

    public BigDecimal getCostoKmBase() {
        return costoKmBase;
    }

    public void setCostoKmBase(BigDecimal costoKmBase) {
        this.costoKmBase = costoKmBase;
    }

    public BigDecimal getCargoFijoTramo() {
        return cargoFijoTramo;
    }

    public void setCargoFijoTramo(BigDecimal cargoFijoTramo) {
        this.cargoFijoTramo = cargoFijoTramo;
    }

    public BigDecimal getValorCombustible() {
        return valorCombustible;
    }

    public void setValorCombustible(BigDecimal valorCombustible) {
        this.valorCombustible = valorCombustible;
    }

    public Double getConsumoPromedio() {
        return consumoPromedio;
    }

    public void setConsumoPromedio(Double consumoPromedio) {
        this.consumoPromedio = consumoPromedio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}