package io.github.thiago.vendas.service.impl;

import io.github.thiago.vendas.domain.repository.Pedidos;
import io.github.thiago.vendas.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {
  private Pedidos repository;

    public PedidoServiceImpl(Pedidos repository) {
        this.repository = repository;
    }

}
