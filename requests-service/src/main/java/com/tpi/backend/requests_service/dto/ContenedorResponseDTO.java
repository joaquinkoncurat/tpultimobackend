package com.tpi.backend.requests_service.dto;

import lombok.Data;

@Data
public class ContenedorResponseDTO {
    private Long id;
    private Double peso;
    private Double volumen;
    private Long clienteId;
}
