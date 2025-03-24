package com.example.biblioteca.controller;

import com.example.biblioteca.database.ClienteBanco;
import com.example.biblioteca.database.EmprestimoBanco;
import com.example.biblioteca.model.Cliente;
import java.util.List;

public class ClienteController {

    ClienteBanco banco = ClienteBanco.getInstance();
    public List<Cliente> listarClientes() {
        return banco.findAllCliente();
    }

    public String postarCliente(Cliente c) {
        return banco.insertCliente(c);
    }

    public boolean atualizarCliente(Long id, Cliente cliente) {
        return banco.updateCliente(id,cliente);
    }

    public boolean deletarCliente(Long id) {
        return banco.deleteCliente(id);
    }
}
