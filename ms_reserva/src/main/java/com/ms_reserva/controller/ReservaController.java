package com.ms_reserva.controller;

import com.ms_reserva.dto.OrdenDto;
import com.ms_reserva.service.OrdenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/booking")
public class ReservaController {

    private final OrdenService ordenService;

    @PostMapping("/order")
    public ResponseEntity<String> guardarOrden (@RequestBody OrdenDto ordenDto){
        return ResponseEntity.ok(ordenService.guardarOrden(ordenDto));
    }
}
