package com.marketplace_producto.repository;


import com.marketplace_producto.entity.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductoRepository extends MongoRepository<Producto, String> {

}
