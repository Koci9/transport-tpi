package utnfrc.isi.back.tpi.tarifas.dto;

import java.math.BigDecimal;

public class ValidacionCamionRequest {
    private BigDecimal pesoContenedor;
    private BigDecimal volumenContenedor;

    public ValidacionCamionRequest() {
    }

    public BigDecimal getPesoContenedor() {
        return pesoContenedor;
    }

    public void setPesoContenedor(BigDecimal pesoContenedor) {
        this.pesoContenedor = pesoContenedor;
    }

    public BigDecimal getVolumenContenedor() {
        return volumenContenedor;
    }

    public void setVolumenContenedor(BigDecimal volumenContenedor) {
        this.volumenContenedor = volumenContenedor;
    }
}