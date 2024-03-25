package io.github.thiago.vendas.service;


import io.github.thiago.vendas.domain.entity.Pedido;
import io.github.thiago.vendas.domain.enums.StatusPedido;
import io.github.thiago.vendas.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
 Pedido salvar(PedidoDTO dto);

 Optional<Pedido> obterPedidoCompleto(Integer id);
  void atualizaStatus(Integer id, StatusPedido statusPedido);

 }
