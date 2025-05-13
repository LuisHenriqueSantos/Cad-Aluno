package com.mentorama.cadastroaluno.exception;

public class AlunoNotFoundException extends RuntimeException {

    public AlunoNotFoundException(String message) {
        super(message);
    }

    public AlunoNotFoundException(Integer id) {
        super("Aluno não encontrado com o ID: " + id);
    }

    public AlunoNotFoundException(String nome, String tipo) {
        super("Aluno não encontrado com o " + tipo + ": " + nome);
    }
}