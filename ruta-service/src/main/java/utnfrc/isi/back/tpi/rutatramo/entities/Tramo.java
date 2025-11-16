package utnfrc.isi.back.tpi.rutatramo.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tramo")
@Getter
@Setter
public class Tramo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_ruta")
    private Ruta ruta;

    private String origen;
    private String destino;

    private String tipo;
    private String estado;

    private Double distanciaKm;
    private Double costoAproximado;
    private Double costoReal;

    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

    private Long idCamion;
    private Long idDeposito;
}

