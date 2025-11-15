package ar.edu.tpi.common.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CrearSolicitudDto {

    @NotNull
    @Valid
    private ClienteDto cliente;

    @NotNull
    @Valid
    private ContenedorDto contenedor;

    @Size(max = 150)
    private String origenDireccion;

    @Size(max = 150)
    private String destinoDireccion;

    // Optionally include coordinates as strings "lat,lng" or separate fields
    private String origenCoords;
    private String destinoCoords;

    public CrearSolicitudDto() {
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public ContenedorDto getContenedor() {
        return contenedor;
    }

    public void setContenedor(ContenedorDto contenedor) {
        this.contenedor = contenedor;
    }

    public String getOrigenDireccion() {
        return origenDireccion;
    }

    public void setOrigenDireccion(String origenDireccion) {
        this.origenDireccion = origenDireccion;
    }

    public String getDestinoDireccion() {
        return destinoDireccion;
    }

    public void setDestinoDireccion(String destinoDireccion) {
        this.destinoDireccion = destinoDireccion;
    }

    public String getOrigenCoords() {
        return origenCoords;
    }

    public void setOrigenCoords(String origenCoords) {
        this.origenCoords = origenCoords;
    }

    public String getDestinoCoords() {
        return destinoCoords;
    }

    public void setDestinoCoords(String destinoCoords) {
        this.destinoCoords = destinoCoords;
    }
}