package com.example.biblioteca.controller;

import com.example.biblioteca.database.LivroBanco;
import com.example.biblioteca.model.Livro;
import java.util.List;

public class LivroController {
    LivroBanco banco = LivroBanco.getInstance();
    public List<Livro> listarLivros() {
        return banco.findAllLivro();
    }

    public String postarLivro(Livro l) {
        return banco.insertLivro(l);
    }

    public boolean atualizarLivro(Long id, Livro l) {
        return banco.updateLivro(id,l);
    }

    public boolean deletarLivro(Long id) {
        return banco.deleteLivro(id);
    }
}
