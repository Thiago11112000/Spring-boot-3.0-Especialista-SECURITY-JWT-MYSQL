package io.github.thiago.vendas.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Produto")
@Data
@NoArgsConstructor
@AllArgsConstructor



public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco_unitario"  )
    private BigDecimal preco;


}
