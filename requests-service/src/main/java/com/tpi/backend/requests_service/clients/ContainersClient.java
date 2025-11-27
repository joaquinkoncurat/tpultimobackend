package com.tpi.backend.requests_service.clients;

import com.tpi.backend.requests_service.dto.ContenedorRequest;
import com.tpi.backend.requests_service.dto.ContenedorResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "containers-service", url = "http://containers-service:8085")
public interface ContainersClient {
    @PostMapping("/contenedores")
    ContenedorResponseDTO crearContenedor(@RequestBody ContenedorRequest request);
}
