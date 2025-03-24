package com.example.biblioteca.view;

import com.example.biblioteca.controller.LivroController;
import com.example.biblioteca.model.Livro;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroView {
    LivroController lc = new LivroController();

    @GetMapping
    public List<Livro> getLivros(){
        return lc.listarLivros();
    }

    @PostMapping
    public String postLivro(@RequestBody Livro l){
        return lc.postarLivro(l);
    }

    @PutMapping("/atualizar/{id}")
    public String atualizarLivro(@PathVariable Long id, @RequestBody Livro l){
        if(lc.atualizarLivro(id,l)){
            return "Sucesso ao atualizar o livro!";
        } else {
            return "Falha ao atualizar o livro...";
        }
    }

    @DeleteMapping("/{id}")
    public String deletarLivro(@PathVariable Long id){
        if(lc.deletarLivro(id)){
            return "Deletado com sucesso";
        } else {
            return "Falha ao deletar...";
        }
    }
}
