package com.ms_reserva.service;

import com.ms_reserva.client.StockClient;
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
    private final StockClient stockClient;

    public String guardarOrden(OrdenDto ordenDto){

        boolean hayStockDisponible = ordenDto.getOrdenItems().stream()
                .allMatch(ordenItem -> stockClient.existeStock(ordenItem.getCodigo()));

        if(hayStockDisponible){
            Orden orden = new Orden();
            orden.setNumeroOrden(UUID.randomUUID().toString());
            orden.setOrdenItems(ordenDto.getOrdenItems());

            ordenRepository.save(orden);

            return "Orden guardada";
        }
        return "Orden cancelada";
    }
}
