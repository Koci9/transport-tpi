package utnfrc.isi.back.tpi.rutatramo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ruta")
@Getter
@Setter
public class Ruta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idSolicitud;
    private Integer cantidadTramos;
    private Integer cantidadDepositos;
}