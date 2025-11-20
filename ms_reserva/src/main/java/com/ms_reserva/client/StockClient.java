package com.ms_reserva.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "ms-stock")
public interface StockClient {

    @RequestMapping("/api/stock/{codigo}")
    boolean existeStock (@PathVariable String codigo);
}
