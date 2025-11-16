package utnfrc.isi.back.tpi.solicliente.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import utnfrc.isi.back.tpi.common.dto.ClienteDto;
import utnfrc.isi.back.tpi.common.dto.ContenedorDto;

@Data
public class CrearSolicitudRequest {
    @NotNull
    private ClienteDto cliente;
    @NotNull
    private ContenedorDto contenedor;
    @Size(max = 150)
    private String origenDireccion;
    @Size(max = 150)
    private String destinoDireccion;
    private String origenCoords;
    private String destinoCoords;
}