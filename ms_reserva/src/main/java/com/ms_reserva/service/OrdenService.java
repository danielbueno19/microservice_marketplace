package com.ms_reserva.service;

import com.ms_reserva.client.StockClient;
import com.ms_reserva.dto.OrdenDto;
import com.ms_reserva.entity.Orden;
import com.ms_reserva.repository.OrdenRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrdenService {

    private final OrdenRepository ordenRepository;
    private final StockClient stockClient;

    @HystrixCommand(fallbackMethod = "fallbackOrdenToStock")
    public String guardarOrden(OrdenDto ordenDto){

        boolean hayStockDisponible = ordenDto.getOrdenItems().stream()
                .allMatch(ordenItem -> stockClient.isStockDisponible(ordenItem.getCodigo()));

        if(hayStockDisponible){
            Orden orden = new Orden();
            orden.setNumeroOrden(UUID.randomUUID().toString());
            orden.setOrdenItems(ordenDto.getOrdenItems());

            ordenRepository.save(orden);

            return "Orden guardada";
        }
        return "Orden cancelada";
    }

    public String fallbackOrdenToStock (OrdenDto ordenDto, Throwable t){
        return "Algo salió mal, intenta más tarde";
    }
}
