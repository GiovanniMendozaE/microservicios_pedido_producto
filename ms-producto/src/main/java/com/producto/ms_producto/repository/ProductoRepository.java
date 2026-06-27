package com.producto.ms_producto.repository;


import com.producto.ms_producto.model.entity.ProductoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends CrudRepository<ProductoEntity, Integer> {
}
