package com.producto.ms_producto.service.impl;


import com.producto.ms_producto.model.dto.ProductoRequest;
import com.producto.ms_producto.model.dto.ProductoResponse;
import com.producto.ms_producto.model.entity.ProductoEntity;
import com.producto.ms_producto.model.mapper.ProductoMapper;
import com.producto.ms_producto.repository.ProductoRepository;
import com.producto.ms_producto.service.ProductoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository repository;
    private final ProductoMapper productoMapper = ProductoMapper.MAPPER;

    public ProductoServiceImpl(ProductoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void registerProducto(ProductoRequest productoRequest) {
        var entity = productoMapper.toProductoEntity(productoRequest);
        repository.save(entity);
    }

    @Override
    public Iterable<ProductoResponse> getProductos() {
        var productos = repository.findAll();
        var res = new ArrayList<ProductoResponse>();
        productos.forEach(x -> {
            var producto = productoMapper.toProductoResponse(x);
            res.add(producto);
        });

        return res;
    }

    @Override
    public void updateProducto(ProductoRequest productoRequest) {
        var producto = repository.findById(productoRequest.getId());

        if (producto.isEmpty()) {
            throw new RuntimeException("Error producto no existe");
        }

        producto.get().setNombre(productoRequest.getNombre());
        producto.get().setPrecio(productoRequest.getPrecio());

        repository.save(producto.get());
    }

    @Override
    public void removeProducto(int id) {
        repository.deleteById(id);
    }

    @Override
    public ProductoResponse getProductoById(int id) {
        ProductoEntity entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));
        return productoMapper.toProductoResponse(entity);
    }
}