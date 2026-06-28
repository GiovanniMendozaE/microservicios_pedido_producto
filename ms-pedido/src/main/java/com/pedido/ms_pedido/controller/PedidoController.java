package com.pedido.ms_pedido.controller;

import com.pedido.ms_pedido.model.dto.PedidoRequest;
import com.pedido.ms_pedido.model.dto.PedidoResponse;
import com.pedido.ms_pedido.service.PedidoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public List<PedidoResponse> obtenerTodos() {
        return pedidoService.getPedidos();
    }

    @PostMapping("/register")
    public void registrar(@RequestBody PedidoRequest request) {
        pedidoService.registrarPedido(request);
    }
}