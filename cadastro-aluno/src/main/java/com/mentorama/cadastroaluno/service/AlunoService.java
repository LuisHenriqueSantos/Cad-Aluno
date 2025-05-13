package com.mentorama.cadastroaluno.service;

import com.mentorama.cadastroaluno.Aluno;
import com.mentorama.cadastroaluno.exception.AlunoNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final List<Aluno> alunos;

    public AlunoService() {
        this.alunos = new ArrayList<>();
    }

    public Integer addAluno(Aluno aluno) {
        if(aluno.getId() == null) {
            aluno.setId(alunos.size() + 1);
        }
        alunos.add(aluno);
        return aluno.getId();
    }

    public List<Aluno> findAllAlunos(String nome, Integer idade) {
        return alunos.stream()
                .filter(alu -> (nome == null || alu.getNome().contains(nome)))
                .filter(alu -> (idade == null || alu.getIdade().equals(idade)))
                .collect(Collectors.toList());
    }

    public Aluno findAlunoById(Integer id) {
        return this.alunos.stream()
                .filter(alu -> alu.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new AlunoNotFoundException(id));
    }

    public Aluno findAlunoByNome(String nome) {
        return this.alunos.stream()
                .filter(alu -> alu.getNome().equals(nome))
                .findFirst()
                .orElseThrow(() -> new AlunoNotFoundException(nome, "nome"));
    }

    public Aluno updateAluno(Integer id, Aluno alunoAtualizado) {
        Aluno alunoExistente = findAlunoById(id);

        alunoExistente.setNome(alunoAtualizado.getNome());
        alunoExistente.setIdade(alunoAtualizado.getIdade());
        alunoExistente.setId(id);

        return alunoExistente;
    }

    public void deleteAluno(Integer id) {
        findAlunoById(id);
        alunos.removeIf(alu -> alu.getId().equals(id));
    }
}