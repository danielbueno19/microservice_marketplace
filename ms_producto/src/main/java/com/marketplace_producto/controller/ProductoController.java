package com.marketplace_producto.controller;

import com.marketplace_producto.entity.Producto;
import com.marketplace_producto.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductoController {

    private final ProductoRepository productoRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Producto>> getAllProductos(){
        return ResponseEntity.ok(productoRepository.findAll());
    }

    @PostMapping("/save")
    public ResponseEntity<Void> crearProducto (@RequestBody Producto producto){
        productoRepository.save(producto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
