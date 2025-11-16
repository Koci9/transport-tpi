package utnfrc.isi.back.tpi.tarifas.dto;

import java.math.BigDecimal;

public class CosteoTramoResponse {
    private BigDecimal costoKm;
    private BigDecimal costoCombustible;
    private BigDecimal cargoFijo;
    private BigDecimal costoTotal;

    public CosteoTramoResponse() {
    }

    public BigDecimal getCostoKm() {
        return costoKm;
    }

    public void setCostoKm(BigDecimal costoKm) {
        this.costoKm = costoKm;
    }

    public BigDecimal getCostoCombustible() {
        return costoCombustible;
    }

    public void setCostoCombustible(BigDecimal costoCombustible) {
        this.costoCombustible = costoCombustible;
    }

    public BigDecimal getCargoFijo() {
        return cargoFijo;
    }

    public void setCargoFijo(BigDecimal cargoFijo) {
        this.cargoFijo = cargoFijo;
    }

    public BigDecimal getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(BigDecimal costoTotal) {
        this.costoTotal = costoTotal;
    }
}