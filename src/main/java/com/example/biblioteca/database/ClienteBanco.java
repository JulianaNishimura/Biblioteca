package com.example.biblioteca.database;

import com.example.biblioteca.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteBanco {
    private static ClienteBanco instance;
    private List<Cliente> clientes = new ArrayList<>();

    public static ClienteBanco getInstance(){
        if (instance == null){
            instance = new ClienteBanco();
        }
        return instance;
    }

    public String insertCliente(Cliente c){
        for(Cliente cExistente : clientes){
            if(cExistente.getId() == c.getId()){
                return "Id já existente.";
            }
            if(cExistente.getCpf().equals( c.getCpf())){
                return "Cpf já cadastrado.";
            }
        }
        clientes.add(c);
        return "Cadastrado com sucesso";
    }

    public Cliente findOneCliente(Long id){
        for(Cliente c : clientes){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }

    public List<Cliente> findAllCliente(){
        return new ArrayList<>(clientes);
    }

    public boolean updateCliente(Long id, Cliente c){
        for(int i = 0; i < clientes.size(); i++){
            if(clientes.get(i).getId() == id){
                c.setId(id);
                clientes.set(i,c);
                return true;
            }
        }
        return false;
    }

    public boolean deleteCliente(Long id){
        return clientes.removeIf(c -> c.getId() == id);
    }
}
