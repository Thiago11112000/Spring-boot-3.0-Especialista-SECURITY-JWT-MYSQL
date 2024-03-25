package io.github.thiago.vendas.exception;

public class PedidoNaoEncontradoException extends RuntimeException {

    public PedidoNaoEncontradoException() {
        super("Pedido Não encontrado.");
    }
}
