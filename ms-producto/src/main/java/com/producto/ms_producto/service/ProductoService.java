package com.producto.ms_producto.service;


import com.producto.ms_producto.model.dto.ProductoRequest;
import com.producto.ms_producto.model.dto.ProductoResponse;

public interface ProductoService {
    ProductoResponse getProductoById(int id);
    void registerProducto(ProductoRequest productoRequest);
    Iterable<ProductoResponse> getProductos();
    void updateProducto(ProductoRequest productoRequest);
    void removeProducto(int id);
}
