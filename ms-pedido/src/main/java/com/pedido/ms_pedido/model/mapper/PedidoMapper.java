package com.pedido.ms_pedido.model.mapper;

import com.pedido.ms_pedido.model.dto.PedidoRequest;
import com.pedido.ms_pedido.model.dto.PedidoResponse;
import com.pedido.ms_pedido.model.entity.PedidoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper(componentModel = "spring")
public interface PedidoMapper {
    PedidoMapper INSTANCE = Mappers.getMapper(PedidoMapper.class);

    PedidoEntity toEntity(PedidoRequest request);
    PedidoResponse toResponse(PedidoEntity entity);

}
