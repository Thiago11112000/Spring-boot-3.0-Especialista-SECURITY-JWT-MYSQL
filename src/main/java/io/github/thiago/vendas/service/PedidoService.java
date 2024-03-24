package io.github.thiago.vendas.service;

import io.github.thiago.vendas.domain.entity.Pedido;
import io.github.thiago.vendas.rest.dto.PedidoDTO;

public interface PedidoService {
 Pedido salvar(PedidoDTO dto);


 }
