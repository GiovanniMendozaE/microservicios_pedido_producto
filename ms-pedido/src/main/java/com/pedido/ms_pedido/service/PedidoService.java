package com.pedido.ms_pedido.service;

import com.pedido.ms_pedido.model.dto.PedidoRequest;
import com.pedido.ms_pedido.model.dto.PedidoResponse;

public interface PedidoService {
    Iterable<PedidoResponse> getPedidos();
    void registrarPedido(PedidoRequest request);
}
