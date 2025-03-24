package com.example.biblioteca.view;

import com.example.biblioteca.controller.ClienteController;
import com.example.biblioteca.model.Cliente;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteView {
    ClienteController cc = new ClienteController();

    @GetMapping
    public List<Cliente> getClientes(){
        return cc.listarClientes();
    }

    @PostMapping
    public String postCliente(Cliente c){
        return cc.postarCliente(c);
    }

    @PutMapping("/atualizar/{id}")
    public String atualizarCliente(@PathVariable Long id, Cliente c){
        if(cc.atualizarCliente(id,c)){
            return "Sucesso ao atualizar o cliente!";
        } else {
            return "Falha ao atualizar o cliente...";
        }
    }

    @DeleteMapping("/{id}")
    public String deletarCliente(@PathVariable Long id){
        if(cc.deletarCliente(id)){
            return "Deletado com sucesso";
        } else {
            return "Falha ao deletar...";
        }
    }
}
