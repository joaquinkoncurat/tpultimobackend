package com.tpi.backend.requests_service.controllers;

import com.tpi.backend.requests_service.dto.SolicitudRequest;
import com.tpi.backend.requests_service.dto.SolicitudResponseDTO;
import com.tpi.backend.requests_service.models.EstadoSolicitud;
import com.tpi.backend.requests_service.models.Solicitud;
import com.tpi.backend.requests_service.services.SolicitudService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/solicitudes")
@RequiredArgsConstructor
public class SolicitudController {

    private final SolicitudService solicitudService;

    @PostMapping
    public ResponseEntity<Solicitud> crear(@RequestBody SolicitudRequest req) {
        return ResponseEntity.ok(solicitudService.crearSolicitud(req));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitud> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(solicitudService.obtener(id));
    }

    @PutMapping("/{id}/asignar-ruta")
    public ResponseEntity<Solicitud> asignarRuta(@PathVariable Long id) {
        return ResponseEntity.ok(solicitudService.asignarRuta(id));
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Solicitud>> porEstado(@PathVariable EstadoSolicitud estado) {
        return ResponseEntity.ok(solicitudService.listarPorEstado(estado));
    }
}
