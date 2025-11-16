package utnfrc.isi.back.tpi.rutatramo.controllers;

import utnfrc.isi.back.tpi.rutatramo.services.TramoService;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tramos")
@RequiredArgsConstructor
public class TramoController {

    private final TramoService tramoService;

    @PutMapping("/{id}/iniciar")
    public Object iniciar(@PathVariable Long id) {
        return tramoService.iniciarTramo(id);
    }

    @PutMapping("/{id}/finalizar")
    public Object finalizar(@PathVariable Long id) {
        return tramoService.finalizarTramo(id);
    }
}