package io.github.thiago.vendas.service;


import io.github.thiago.vendas.domain.entity.Pedido;
import io.github.thiago.vendas.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
 Pedido salvar(PedidoDTO dto);

 Optional<Pedido> obterPedidoCompleto(Integer id);

 }
