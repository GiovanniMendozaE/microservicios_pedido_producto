package com.producto.ms_producto.controller;


import com.producto.ms_producto.model.dto.ProductoRequest;
import com.producto.ms_producto.model.dto.ProductoResponse;
import com.producto.ms_producto.service.ProductoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/productos")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public Iterable<ProductoResponse> obtenerTodos() {
        return productoService.getProductos();
    }

    @GetMapping("/{id}")
    public ProductoResponse obtenerPorId(@PathVariable("id") int id) {
        return productoService.getProductoById(id);
    }

    @PostMapping("/register")
    public void register(@RequestBody ProductoRequest productoRequest) {
        productoService.registerProducto(productoRequest);
    }

    @PutMapping("/update")
    public void update(@RequestBody ProductoRequest productoRequest) {
        productoService.updateProducto(productoRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable("id") int id) {
        productoService.removeProducto(id);
    }
}