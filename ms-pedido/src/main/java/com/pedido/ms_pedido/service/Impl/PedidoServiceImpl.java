package com.pedido.ms_pedido.service.Impl;

import com.pedido.ms_pedido.model.dto.PedidoRequest;
import com.pedido.ms_pedido.model.dto.ProductoExternalDto;
import com.pedido.ms_pedido.model.entity.PedidoEntity;
import com.pedido.ms_pedido.model.mapper.PedidoMapper;
import com.pedido.ms_pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PedidoServiceImpl {
    private final PedidoRepository pedidoRepository;
    private final PedidoMapper pedidoMapper;
    private final RestTemplate restTemplate;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, PedidoMapper pedidoMapper, RestTemplate restTemplate) {
        this.pedidoRepository = pedidoRepository;
        this.pedidoMapper = pedidoMapper;
        this.restTemplate = restTemplate;
    }

    public void registrarPedido(PedidoRequest request) {

        String url = "http://ms-producto:8081/v1/productos/" + request.getProductoId();
        ProductoExternalDto producto = restTemplate.getForObject(url, ProductoExternalDto.class);

        if (producto == null) {
            throw new RuntimeException("El producto no existe");
        }

        PedidoEntity pedido = pedidoMapper.toEntity(request);

        pedido.setTotal(producto.getPrecio() * request.getCantidad());

        pedidoRepository.save(pedido);
    }
}
