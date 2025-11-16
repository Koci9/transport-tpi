package utnfrc.isi.back.tpi.solicliente.repositories;

import utnfrc.isi.back.tpi.solicliente.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByEmail(String email);
}
