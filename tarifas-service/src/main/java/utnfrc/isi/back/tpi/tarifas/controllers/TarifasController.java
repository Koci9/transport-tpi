package utnfrc.isi.back.tpi.tarifas.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utnfrc.isi.back.tpi.tarifas.services.TarifasService;
import utnfrc.isi.back.tpi.tarifas.dto.ValidacionCamionRequest;
import utnfrc.isi.back.tpi.tarifas.dto.CosteoTramoResponse;

@RestController
@RequestMapping("/api/tarifas")
@RequiredArgsConstructor
public class TarifasController {
    private final TarifasService tarifasService;

    @GetMapping("/camiones/disponibles")
    public ResponseEntity<?> camionesDisponibles() {
        return ResponseEntity.ok(tarifasService.obtenerCamionesDisponibles());
    }

    @PostMapping("/camion/{id}/validar-capacidad")
    public ResponseEntity<?> validarCapacidad(@PathVariable Long id, @RequestBody ValidacionCamionRequest req) {
        boolean ok = tarifasService.validarCapacidad(id, req);
        return ResponseEntity.ok(ok);
    }

    @GetMapping("/camion/{id}/costeo")
    public ResponseEntity<CosteoTramoResponse> costeo(@PathVariable Long id, @RequestParam double distanciaKm) {
        CosteoTramoResponse resp = tarifasService.calcularCostoTramo(id, distanciaKm);
        return ResponseEntity.ok(resp);
    }
}