package com.example.biblioteca.view;

import com.example.biblioteca.controller.EmprestimoController;
import com.example.biblioteca.model.Emprestimo;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoView {
    EmprestimoController ec = new EmprestimoController();

    @GetMapping
    public List<Emprestimo> getEmprestimos(){
        return ec.listarEmprestimos();
    }

    @GetMapping("/{dataFim}")
    public List<Emprestimo> getEmprestimos(@PathVariable String dataFim){
        return ec.listarEmprestimosPelaDataFinal(dataFim);
    }

    @PostMapping
    public String postEmprestimo(@RequestBody Emprestimo e){
        return ec.postarEmprestimo(e);
    }

    @PutMapping("/atualizar/{id}")
    public String atualizarEmprestimo(@PathVariable Long id, @RequestBody Emprestimo e){
        if(ec.atualizarEmprestimo(id,e)){
            return "Sucesso ao atualizar o empréstimo!";
        } else {
            return "Falha ao atualizar o empréstimo...";
        }
    }

    @DeleteMapping("/{id}")
    public String deletarEmprestimo(@PathVariable Long id){
        if(ec.deletarEmprestimo(id)){
            return "Deletado com sucesso";
        } else {
            return "Falha ao deletar...";
        }
    }
}
