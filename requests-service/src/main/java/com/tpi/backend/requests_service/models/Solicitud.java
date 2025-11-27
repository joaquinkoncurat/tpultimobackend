package com.tpi.backend.requests_service.models;

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
    private Long numero;  // ESTE ES EL ID DE LA SOLICITUD

    private Long contenedorId; 

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estado;

    private Double costoEstimado;
    private Double costoFinal;

    private Integer tiempoEstimado; 
    private Integer tiempoReal;

    private String direccionDestino;
    private Double latitudDestino;
    private Double longitudDestino;

    // NECESARIO PARA GUARDAR LA RUTA GENERADA EN ROUTES-SERVICE
    private Long rutaId;

}
