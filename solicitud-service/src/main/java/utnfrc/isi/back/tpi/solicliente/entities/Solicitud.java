package utnfrc.isi.back.tpi.solicliente.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "solicitud")
public class Solicitud {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSolicitud;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "id_contenedor", nullable = false)
    private Contenedor contenedor;

    private BigDecimal costoEstimado;
    private Double tiempoEstimado;

    private BigDecimal costoFinal;
    private Double tiempoReal;

    @Column(nullable = false, length = 30)
    private String estado = "BORRADOR";

    @Column(nullable = false)
    private LocalDateTime fechaCreacion = LocalDateTime.now();

    // getters & setters
}