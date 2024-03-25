package io.github.thiago.vendas.rest.controller;

import io.github.thiago.vendas.domain.entity.ItemPedido;
import io.github.thiago.vendas.domain.entity.Pedido;
import io.github.thiago.vendas.domain.enums.StatusPedido;
import io.github.thiago.vendas.rest.dto.AtualizacaoStatusPedidoDTO;
import io.github.thiago.vendas.rest.dto.InformacaoItemPedidoDTO;
import io.github.thiago.vendas.rest.dto.InformacoesPedidosDTO;
import io.github.thiago.vendas.rest.dto.PedidoDTO;
import io.github.thiago.vendas.service.PedidoService;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

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

    @GetMapping("{id}")
    public InformacoesPedidosDTO getById(@PathVariable  Integer id){
      return service
              .obterPedidoCompleto(id)
              .map(p -> converter(p)
              )
              .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Pedido não Encontrado"));
    }
    @PatchMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void updateStatus(@PathVariable Integer id ,
                             @RequestBody AtualizacaoStatusPedidoDTO dto){
        String novoStatus = dto.getNovoStatus();
        service.atualizaStatus(id, StatusPedido.valueOf(novoStatus));
    }
    private InformacoesPedidosDTO converter(Pedido  pedido){
      return  InformacoesPedidosDTO
                .builder()
                .codigo(pedido.getId())
                .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                .cpf(pedido.getCliente().getCpf())
                .nomeCliente(pedido.getCliente().getNome())
                .total(pedido.getTotal())
              .status(pedido.getStatus().name())
                .items(converter(pedido.getItems()))
                .build();
    }
    private  List <InformacaoItemPedidoDTO>  converter(List<ItemPedido> items){
   if (CollectionUtils.isEmpty(items)){
       return Collections.emptyList();
   }
   return items.stream().map(
           item -> InformacaoItemPedidoDTO.builder()
                   .descricaoProduto(item.getProduto().getDescricao())
                   .precoUnitario((item.getProduto().getPreco()))
                   .quantidade(item.getQuantidade())
                   .build()
   ).collect(Collectors.toList());
    }
}