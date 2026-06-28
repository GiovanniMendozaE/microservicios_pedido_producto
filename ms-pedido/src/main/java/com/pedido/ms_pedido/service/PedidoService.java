package com.pedido.ms_pedido.service;

import com.pedido.ms_pedido.model.dto.PedidoRequest;
import com.pedido.ms_pedido.model.dto.PedidoResponse;

import java.util.List;

public interface PedidoService {
    List<PedidoResponse> getPedidos();
    void registrarPedido(PedidoRequest request);
}