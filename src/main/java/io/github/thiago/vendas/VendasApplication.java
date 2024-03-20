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
        System.out.println("Salvando Clientes");
        Cliente cliente = new Cliente();
        cliente.setNome("Douglas");
        clientes.salvar(cliente);

        Cliente cliente2= new Cliente("Outro Cliente");
        clientes.salvar(cliente2);

        clientes.salvar(new Cliente("Terceiro cliente"));

        List<Cliente> todosClientes  = clientes.obterTodos();
        todosClientes.forEach(System.out::println );

//        System.out.println("Editando Clientes");
//        todosClientes.forEach(c -> {
//            c.setNome(c.getNome() + " atualizado");
//            clientes.atualizar(c);
//        });
//
//        todosClientes  = clientes.obterTodos();
//        todosClientes.forEach(System.out::println );
//        System.out.println("Buscando Clientes");
//        clientes.buscarPorNome("Cli").forEach(System.out::println);

//        System.out.println("Deletando Clientes");
//        clientes.obterTodos().forEach(c -> {
//            clientes.deletar(c);
//        });

//        todosClientes = clientes.obterTodos();
//        if (todosClientes.isEmpty()) {
//            System.out.println("Nenhum Cliente encontrado");
//        } else
//            todosClientes.forEach(System.out::println);
    };
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
