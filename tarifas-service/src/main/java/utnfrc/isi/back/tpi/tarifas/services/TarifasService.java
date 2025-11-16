package utnfrc.isi.back.tpi.tarifas.services;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import utnfrc.isi.back.tpi.tarifas.repositories.CamionRepository;
import utnfrc.isi.back.tpi.tarifas.repositories.TarifaRepository;
import utnfrc.isi.back.tpi.tarifas.entities.Camion;
import utnfrc.isi.back.tpi.tarifas.entities.Tarifa;
import utnfrc.isi.back.tpi.tarifas.dto.ValidacionCamionRequest;
import utnfrc.isi.back.tpi.tarifas.dto.CosteoTramoResponse;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarifasService {
    private final TarifaRepository tarifaRepository;
    private final CamionRepository camionRepository;

    public List<Camion> obtenerCamionesDisponibles() {
        return camionRepository.findByDisponibleTrue();
    }

    public boolean validarCapacidad(Long idCamion, ValidacionCamionRequest req) {
        Camion c = camionRepository.findById(idCamion).orElseThrow(() -> new RuntimeException("Camión no encontrado"));
        return c.getCapacidadPeso().compareTo(req.getPesoContenedor()) >= 0
                && c.getCapacidadVolumen().compareTo(req.getVolumenContenedor()) >= 0;
    }

    public CosteoTramoResponse calcularCostoTramo(Long idCamion, double distanciaKm) {
        Camion c = camionRepository.findById(idCamion).orElseThrow(() -> new RuntimeException("Camión no encontrado"));
        Tarifa t = c.getTarifa();

        BigDecimal distancia = BigDecimal.valueOf(distanciaKm);
        BigDecimal costoKm = t.getCostoKmBase().multiply(distancia);
        BigDecimal consumo = BigDecimal.valueOf(c.getTarifa().getConsumoPromedio()).multiply(distancia);
        BigDecimal costoCombustible = consumo.multiply(t.getValorCombustible());
        BigDecimal cargoFijo = t.getCargoFijoTramo();
        BigDecimal total = costoKm.add(costoCombustible).add(cargoFijo);

        CosteoTramoResponse resp = new CosteoTramoResponse();
        resp.setCostoKm(costoKm);
        resp.setCostoCombustible(costoCombustible);
        resp.setCargoFijo(cargoFijo);
        resp.setCostoTotal(total);
        return resp;
    }
}