package com.tpi.backend.requests_service.dto;

import lombok.Data;

@Data
public class SolicitudRequest {
    private ClienteDTO cliente;
    private ContenedorDTO contenedor;
    private UbicacionDTO origen;
    private UbicacionDTO destino;
}

@Data
class ClienteDTO {
    private String nombre;
    private String email;
    private String telefono;
}

@Data
class ContenedorDTO {
    private double pesoKg;
    private double volumenM3;
    private String identificacion; // opcional
}

@Data
class UbicacionDTO {
    private double lat;
    private double lon;
    private String direccion;
}