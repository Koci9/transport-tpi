package utnfrc.isi.back.tpi.solicliente.services;

import utnfrc.isi.back.tpi.solicliente.dto.CrearSolicitudRequest;
import utnfrc.isi.back.tpi.solicliente.dto.SolicitudResponse;
import utnfrc.isi.back.tpi.solicliente.entities.Cliente;
import utnfrc.isi.back.tpi.solicliente.entities.Contenedor;
import utnfrc.isi.back.tpi.solicliente.entities.Solicitud;
import utnfrc.isi.back.tpi.solicliente.repositories.ClienteRepository;
import utnfrc.isi.back.tpi.solicliente.repositories.ContenedorRepository;
import utnfrc.isi.back.tpi.solicliente.repositories.SolicitudRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SolicitudService {
    private final ClienteRepository clienteRepository;
    private final ContenedorRepository contenedorRepository;
    private final SolicitudRepository solicitudRepository;

    @Transactional
    public SolicitudResponse crearSolicitud(CrearSolicitudRequest req) {
        // 1 - crear o buscar cliente por email
        Cliente cliente = clienteRepository.findByEmail(req.getCliente().getEmail())
                .orElseGet(() -> {
                    Cliente c = new Cliente();
                    c.setNombre(req.getCliente().getNombre());
                    c.setApellido(req.getCliente().getApellido());
                    c.setEmail(req.getCliente().getEmail());
                    c.setTelefono(req.getCliente().getTelefono());
                    c.setDireccion(req.getCliente().getDireccion());
                    return clienteRepository.save(c);
                });

        // 2 - crear contenedor
        Contenedor cont = new Contenedor();
        cont.setCliente(cliente);
        cont.setPeso(req.getContenedor().getPeso());
        cont.setVolumen(req.getContenedor().getVolumen());
        cont.setEstado("DISPONIBLE");
        cont = contenedorRepository.save(cont);

        // 3 - crear solicitud
        Solicitud s = new Solicitud();
        s.setCliente(cliente);
        s.setContenedor(cont);
        s.setEstado("BORRADOR");
        s = solicitudRepository.save(s);

        SolicitudResponse resp = new SolicitudResponse();
        resp.setId(s.getIdSolicitud());
        resp.setEstado(s.getEstado());
        resp.setMensaje("Solicitud creada");
        return resp;
    }

    public SolicitudResponse obtenerSolicitud(Long id) {
        Solicitud s = solicitudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        SolicitudResponse r = new SolicitudResponse();
        r.setId(s.getIdSolicitud());
        r.setEstado(s.getEstado());
        r.setMensaje("OK");
        return r;
    }
}