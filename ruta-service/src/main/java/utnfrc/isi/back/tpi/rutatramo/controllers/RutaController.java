package utnfrc.isi.back.tpi.rutatramo.controllers;

import utnfrc.isi.back.tpi.rutatramo.services.RutaService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/rutas")
@RequiredArgsConstructor
public class RutaController {

    private final RutaService rutaService;

    @PostMapping
    public Object crearRuta(@RequestBody Object dto) {
        return rutaService.crearRuta(dto);
    }
}
