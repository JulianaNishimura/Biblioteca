package com.example.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.ZonedDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Emprestimo {
    private Long id;
    private String data_inicio;
    private String data_fim;
    private List<Livro> livros_emprestados;
    private Cliente cliente;
}
