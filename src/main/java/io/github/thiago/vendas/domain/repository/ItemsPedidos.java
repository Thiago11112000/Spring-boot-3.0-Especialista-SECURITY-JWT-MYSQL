package io.github.thiago.vendas.domain.repository;

import io.github.thiago.vendas.domain.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsPedidos extends JpaRepository<ItemPedido, Integer> {
}
