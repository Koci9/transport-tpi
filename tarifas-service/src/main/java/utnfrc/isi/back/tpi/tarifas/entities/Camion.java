package utnfrc.isi.back.tpi.tarifas.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "camion")
public class Camion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCamion;

    @Column(nullable = false, length = 15, unique = true)
    private String dominio;

    @Column(length = 100)
    private String nombreTransportista;

    @Column(length = 50)
    private String telefono;

    private BigDecimal capacidadPeso;
    private BigDecimal capacidadVolumen;

    @Column(nullable = false)
    private Boolean disponible = true;

    @ManyToOne
    @JoinColumn(name = "id_tarifa")
    private Tarifa tarifa;

    // getters y setters
    public Long getIdCamion() {
        return idCamion;
    }

    public void setIdCamion(Long idCamion) {
        this.idCamion = idCamion;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getNombreTransportista() {
        return nombreTransportista;
    }

    public void setNombreTransportista(String nombreTransportista) {
        this.nombreTransportista = nombreTransportista;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public BigDecimal getCapacidadPeso() {
        return capacidadPeso;
    }

    public void setCapacidadPeso(BigDecimal capacidadPeso) {
        this.capacidadPeso = capacidadPeso;
    }

    public BigDecimal getCapacidadVolumen() {
        return capacidadVolumen;
    }

    public void setCapacidadVolumen(BigDecimal capacidadVolumen) {
        this.capacidadVolumen = capacidadVolumen;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }
}