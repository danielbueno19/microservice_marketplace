package com.marketplace_producto.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document(value = "producto")
public class Producto {
    @Id
    private String id;
    private String nombre;
    private String descripcion;
    private double precioUnidad;
}
