package com.example.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Cliente {
    private Long id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
}
