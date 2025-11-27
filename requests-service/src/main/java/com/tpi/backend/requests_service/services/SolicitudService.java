package com.tpi.backend.requests_service.services;

import com.tpi.backend.requests_service.clients.ContainersClient;
import com.tpi.backend.requests_service.clients.RoutesClient;
import com.tpi.backend.requests_service.clients.TrackingClient;
import com.tpi.backend.requests_service.dto.*;
import com.tpi.backend.requests_service.models.*;
import com.tpi.backend.requests_service.repositories.*;

import java.time.LocalDateTime;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import lombok.*;

@Service
@RequiredArgsConstructor
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final RoutesClient routesClient;
    private final ContainersClient contenedoresClient;

    public Solicitud crearSolicitud(SolicitudRequest req) {

        // 1. Crear contenedor en el microservicio Containers
        Long contenedorId = contenedoresClient.crearContenedor(
            new ContenedorRequest(
                req.getPesoContenedor(),
                req.getVolumenContenedor(),
                req.getClienteId(),
                req.getDepositoId()
            )
        );

        // 2. Crear solicitud
        Solicitud sol = Solicitud.builder()
                .clienteId(req.getClienteId())
                .contenedorId(contenedorId)
                .estado(EstadoSolicitud.BORRADOR)
                .fechaCreacion(LocalDateTime.now())
                .direccionOrigen(req.getDireccionOrigen())
                .latitudOrigen(req.getLatitudOrigen())
                .longitudOrigen(req.getLongitudOrigen())
                .direccionDestino(req.getDireccionDestino())
                .latitudDestino(req.getLatitudDestino())
                .longitudDestino(req.getLongitudDestino())
                .build();

        return solicitudRepository.save(sol);
    }

    public Solicitud obtener(Long id) {
        return solicitudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
    }

    public Solicitud asignarRuta(Long solicitudId) {

        Solicitud sol = obtener(solicitudId);

        if (sol.getEstado() != EstadoSolicitud.BORRADOR)
            throw new RuntimeException("Solicitud ya procesada");

        // 1. Llamar al Routes-Service
        Ruta ruta = routesClient.estimarRuta(solicitudId);

        // 2. Guardar rutaId en la solicitud
        sol.setRutaId(ruta.getId());
        sol.setEstado(EstadoSolicitud.EN_TRANSITO);

        return solicitudRepository.save(sol);
    }

    public List<Solicitud> listarPorEstado(EstadoSolicitud estado) {
        return solicitudRepository.findByEstado(estado);
    }
}
