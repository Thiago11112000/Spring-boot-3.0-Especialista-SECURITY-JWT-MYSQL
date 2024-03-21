package io.github.thiago.vendas.domain.repository;

import io.github.thiago.vendas.domain.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Produtos extends JpaRepository<Produto, Integer> {



}
