package com.tpi.backend.requests_service.clients;

import com.tpi.backend.requests_service.dto.RutaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import com.tpi.backend.requests_service.models.*;

@FeignClient(name = "routes-service", url = "http://localhost:8082/rutas")
public interface RoutesClient {

    @PostMapping("/estimar")
    Ruta estimarRuta(@RequestParam Long solicitudId);

    @PutMapping("/{rutaId}/asignar-camion")
    Ruta asignarCamiones(@PathVariable Long rutaId);
}