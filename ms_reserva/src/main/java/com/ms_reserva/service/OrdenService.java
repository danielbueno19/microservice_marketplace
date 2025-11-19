package com.ms_reserva.service;

import com.ms_reserva.dto.OrdenDto;
import com.ms_reserva.entity.Orden;
import com.ms_reserva.repository.OrdenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrdenService {

    private final OrdenRepository ordenRepository;

    public String guardarOrden(OrdenDto ordenDto){

        Orden orden = new Orden();
        orden.setNumeroOrden(UUID.randomUUID().toString());
        orden.setOrdenItems(ordenDto.getOrdenItems());

        ordenRepository.save(orden);

        return "Orden guardada";
    }
}
