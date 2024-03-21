package io.github.thiago.vendas.domain.repository;

import io.github.thiago.vendas.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Pedidos  extends JpaRepository<Pedido, Integer> {
}
