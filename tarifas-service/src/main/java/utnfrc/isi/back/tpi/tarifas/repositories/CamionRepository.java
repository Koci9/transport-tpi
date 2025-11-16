package utnfrc.isi.back.tpi.tarifas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utnfrc.isi.back.tpi.tarifas.entities.Camion;
import java.util.List;

public interface CamionRepository extends JpaRepository<Camion, Long> {
    List<Camion> findByDisponibleTrue();
}