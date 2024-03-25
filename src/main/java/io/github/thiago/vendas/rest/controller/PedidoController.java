package io.github.thiago.vendas.rest.controller;


import io.github.thiago.vendas.domain.entity.Pedido;
import io.github.thiago.vendas.rest.dto.PedidoDTO;
import io.github.thiago.vendas.service.PedidoService;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService service;

    public PedidoController(PedidoService service) {
        this.service = service;
    }


    @PostMapping
    @ResponseStatus(CREATED)
    public Integer  save(@RequestBody PedidoDTO dto){
        Pedido pedido = service.salvar(dto);
        return pedido.getId();
    }
}