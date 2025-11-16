package utnfrc.isi.back.tpi.tarifas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import utnfrc.isi.back.tpi.tarifas.entities.Tarifa;

public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
}