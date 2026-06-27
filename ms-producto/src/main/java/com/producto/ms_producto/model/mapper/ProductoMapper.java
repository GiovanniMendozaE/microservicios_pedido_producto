package com.producto.ms_producto.model.mapper;


import com.producto.ms_producto.model.dto.ProductoRequest;
import com.producto.ms_producto.model.dto.ProductoResponse;
import com.producto.ms_producto.model.entity.ProductoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductoMapper {
    ProductoMapper MAPPER = Mappers.getMapper(ProductoMapper.class);
    ProductoResponse toProductoResponse(ProductoEntity entity);
    ProductoEntity toProductoEntity(ProductoRequest request);
}
