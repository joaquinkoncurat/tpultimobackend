package com.tpi.backend.requests_service.models;

import lombok.Data;
import java.util.List;

public class Ruta {
    private Long id;
    private List<Tramo> tramos;
    private Double distanciaTotal;
    private Double tiempoEstimado;
    private Double costoEstimado;
}
