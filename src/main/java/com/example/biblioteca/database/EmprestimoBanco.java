package com.example.biblioteca.database;

import com.example.biblioteca.model.Cliente;
import com.example.biblioteca.model.Emprestimo;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class EmprestimoBanco {
    private static EmprestimoBanco instance;
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public static EmprestimoBanco getInstance(){
        if (instance == null){
            instance = new EmprestimoBanco();
        }
        return instance;
    }

    public String insertEmprestimo(Emprestimo e){
        for(Emprestimo eExistente : emprestimos){
            if(e.getId() == eExistente.getId()){
                return "Id já existente.";
            }
        }
        emprestimos.add(e);
        return "Cadastrado com sucesso";
    }

    public Emprestimo findOneEmprestimo(Long id){
        for(Emprestimo e : emprestimos){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }

    public List<Emprestimo> findEmprestimosDataFinal(String data_final){
        List<Emprestimo> emprestimosPelaData = new ArrayList<>();
        for(Emprestimo e : emprestimos){
            if(e.getData_fim().equals(data_final)){
                emprestimosPelaData.add(e);
            }
        }
        if (emprestimosPelaData.isEmpty()){
            return null;
        }
        return emprestimosPelaData;
    }

    public List<Emprestimo> findAllEmprestimo(){
        return new ArrayList<>(emprestimos);
    }

    public boolean updateEmprestimo(Long id, Emprestimo e){
        for(int i = 0; i < emprestimos.size(); i++){
            if(emprestimos.get(i).getId() == id){
                e.setId(id);
                emprestimos.set(i,e);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmprestimo(Long id){
        return emprestimos.removeIf(e -> e.getId() == id);
    }
}
