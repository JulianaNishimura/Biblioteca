package com.example.biblioteca.controller;

import com.example.biblioteca.database.ClienteBanco;
import com.example.biblioteca.database.EmprestimoBanco;
import com.example.biblioteca.database.LivroBanco;
import com.example.biblioteca.model.Emprestimo;

import java.time.ZonedDateTime;
import java.util.List;

public class EmprestimoController {
    EmprestimoBanco banco = EmprestimoBanco.getInstance();

    public List<Emprestimo> listarEmprestimos() {
        return banco.findAllEmprestimo();
    }

    public String postarEmprestimo(Emprestimo e) {
        return banco.insertEmprestimo(e);
    }

    public boolean atualizarEmprestimo(Long id, Emprestimo e) {
        return banco.updateEmprestimo(id,e);
    }

    public boolean deletarEmprestimo(Long id) {
        return banco.deleteEmprestimo(id);
    }

    public List<Emprestimo> listarEmprestimosPelaDataFinal(String dataFim) {
        return banco.findEmprestimosDataFinal(dataFim);
    }
}
