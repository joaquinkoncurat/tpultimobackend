package com.tpi.backend.requests_service.models;

import lombok.Data;

@Data
public class Tramo {
    private Long id;
    private Long camionId;
    private Double distanciaKm;
    private Double duracionMin;
    private Double costoAproximado;
}
