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
        clientes.save(cliente);

        Cliente cliente2= new Cliente("Outro cliente");
        clientes.save(cliente2);

        clientes.save(new Cliente("Terceiro cliente"));

        List<Cliente> todosClientes  = clientes.findAll();
        todosClientes.forEach(System.out::println );

        System.out.print("Método booleano: ");
       boolean existe =  clientes.existsByNome("Douglas");
       System.out.println(existe);

        System.out.println("Editando Clientes");
        todosClientes.forEach(c -> {
            c.setNome(c.getNome() + " atualizado");
            clientes.save(c);
        });

        todosClientes  = clientes.findAll();
        todosClientes.forEach(System.out::println );
        System.out.println("Buscando Clientes");
        clientes.findByNomeLike("%cli%").forEach(System.out::println);

        System.out.println("Deletando Clientes");
        clientes.findAll().forEach(c -> {
            clientes.delete(c);
        });

        todosClientes = clientes.findAll();
        if (todosClientes.isEmpty()) {
            System.out.println("Nenhum Cliente encontrado");
        } else
            todosClientes.forEach(System.out::println);
    };
    }


    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
