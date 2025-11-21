package com.ms_stock.controller;

import com.ms_stock.entity.Stock;
import com.ms_stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/stock")
public class StockController {

    private final StockRepository stockRepository;

    @GetMapping("/{codigo}")
    public boolean isStockDisponible (@PathVariable String codigo) {
        Optional<Stock> stockDisponible = stockRepository.findByCodigo(codigo);
        stockDisponible.orElseThrow(() -> new RuntimeException("No se encontro el producto"));

        return stockDisponible.get().getCantidad() > 0;
    }
}
