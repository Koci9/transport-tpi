package utnfrc.isi.back.tpi.solicliente.controllers;

import utnfrc.isi.back.tpi.solicliente.dto.CrearSolicitudRequest;
import utnfrc.isi.back.tpi.solicliente.dto.SolicitudResponse;
import utnfrc.isi.back.tpi.solicliente.services.SolicitudService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {
    private final SolicitudService solicitudService;

    @PostMapping
    public ResponseEntity<SolicitudResponse> crearSolicitud(@Valid @RequestBody CrearSolicitudRequest req) {
        SolicitudResponse resp = solicitudService.crearSolicitud(req);
        return ResponseEntity.status(201).body(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SolicitudResponse> obtenerSolicitud(@PathVariable Long id) {
        SolicitudResponse resp = solicitudService.obtenerSolicitud(id);
        return ResponseEntity.ok(resp);
    }
}