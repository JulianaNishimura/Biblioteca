package com.example.biblioteca.database;

import com.example.biblioteca.model.Emprestimo;
import com.example.biblioteca.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroBanco {
    private static LivroBanco instance;
    private List<Livro> livros = new ArrayList<>();

    public static LivroBanco getInstance(){
        if (instance == null){
            instance = new LivroBanco();
        }
        return instance;
    }

    public String insertLivro(Livro l){
        for(Livro lExistente : livros){
            if(l.getId() == lExistente.getId()){
                return "Id já existente.";
            }
        }
        livros.add(l);
        return "Cadastrado com sucesso";
    }

    public Livro findOneLivro(Long id){
        for(Livro l : livros){
            if(l.getId() == id){
                return l;
            }
        }
        return null;
    }

    public List<Livro> findAllLivro(){
        return new ArrayList<>(livros);
    }

    public boolean updateLivro(Long id, Livro l){
        for(int i = 0; i < livros.size(); i++){
            if(livros.get(i).getId() == id){
                l.setId(id);
                livros.set(i,l);
                return true;
            }
        }
        return false;
    }

    public boolean deleteLivro(Long id){
        return livros.removeIf(l -> l.getId() == id);
    }
}
