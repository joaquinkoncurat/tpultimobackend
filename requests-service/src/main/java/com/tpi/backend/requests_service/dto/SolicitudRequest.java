package com.tpi.backend.requests_service.dto;

import lombok.Data;

@Data
public class SolicitudRequest {

    private Long clienteId;

    private Double pesoContenedor;
    private Double volumenContenedor;

    // NUEVOS CAMPOS EXIGIDOS POR EL TPI
    private String direccionOrigen;
    private Double latitudOrigen;
    private Double longitudOrigen;

    private String direccionDestino;
    private Double latitudDestino;
    private Double longitudDestino;

    // Deposito donde inicia el contenedor
    private Long depositoId;
}