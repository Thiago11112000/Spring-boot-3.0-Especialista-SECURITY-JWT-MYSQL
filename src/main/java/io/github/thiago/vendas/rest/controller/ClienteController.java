package io.github.thiago.vendas.rest.controller;


import io.github.thiago.vendas.domain.entity.Cliente;
import io.github.thiago.vendas.domain.repository.Clientes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(
   value =  {"/api/clientes",  "/api/hello"},
        method = RequestMethod.GET,
        consumes = {"application/json", "application/xml"},
        produces = {"application/json", "application/xml"}


)
public class ClienteController {

    @RequestMapping(value="/hello/{nome}")
    @ResponseBody
    public Clientes  helloCliente(@PathVariable("nome") String nomeCliente, @RequestBody Cliente Cliente){
        return String.format("Hello %s", nomeCliente);
    }

}
