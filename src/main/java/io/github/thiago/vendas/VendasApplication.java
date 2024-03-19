package io.github.thiago.vendas;
import io.github.thiago.vendas.domain.entity.Cliente;
import io.github.thiago.vendas.domain.repositorio.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class VendasApplication {


    @Bean
    public CommandLineRunner  init (@Autowired Clientes clientes){
    return args -> {
        Cliente cliente = new Cliente();
        cliente.setNome("Douglas");
        clientes.salvar(cliente);

        Cliente cliente2= new Cliente("Outro Cliente");
        clientes.salvar(cliente2);

        clientes.salvar(new Cliente("Terceiro cliente"));

        List<Cliente> todosClientes  = clientes.obterTodos();
        todosClientes.forEach(System.out::println );
    };


    }
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
