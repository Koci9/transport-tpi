package utnfrc.isi.back.tpi.solicliente.repositories;

import utnfrc.isi.back.tpi.solicliente.entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}
