package com.pedido.ms_pedido.controller;

import com.pedido.ms_pedido.model.dto.PedidoRequest;
import com.pedido.ms_pedido.service.Impl.PedidoServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/pedidos")
public class PedidoController {
    private final PedidoServiceImpl pedidoService;

    public PedidoController(PedidoServiceImpl pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping("/register")
    public void registrar(@RequestBody PedidoRequest request) {
        pedidoService.registrarPedido(request);
    }
}
