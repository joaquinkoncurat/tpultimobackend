package com.tpi.backend.requests_service.dto;

import lombok.Data;

@Data
public class SolicitudResponseDTO {
    private Long numero;        // ID de solicitud
    private String estado;
    private Long clienteId;
    private Long contenedorId;
    private Long rutaId;
    private Double costoEstimado;
    private Integer tiempoEstimado;
    private Double costoFinal;
    private Integer tiempoReal;
}
