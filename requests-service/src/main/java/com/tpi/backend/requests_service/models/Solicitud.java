package com.tpi.backend.requests_service.models;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitud {
 @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numero;

    private Long clienteId;
    private Long contenedorId;
    private Long rutaId;

    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estado;

    private String direccionOrigen;
    private Double latitudOrigen;
    private Double longitudOrigen;

    private String direccionDestino;
    private Double latitudDestino;
    private Double longitudDestino;

    private LocalDateTime fechaCreacion;

}
