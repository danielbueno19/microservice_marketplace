package com.ms_reserva.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-stock")
public interface StockClient {

    @GetMapping("/api/stock/{codigo}")
    boolean isStockDisponible (@PathVariable String codigo);
}
