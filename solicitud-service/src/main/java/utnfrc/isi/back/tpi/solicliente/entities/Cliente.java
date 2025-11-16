package utnfrc.isi.back.tpi.solicliente.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String apellido;

    @Column(nullable = false, length = 120, unique = true)
    private String email;

    @Column(length = 50)
    private String telefono;

    @Column(length = 150)
    private String direccion;

    // getters & setters
}