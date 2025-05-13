package com.mentorama.cadastroaluno;

import com.mentorama.cadastroaluno.exception.AlunoNotFoundException;
import com.mentorama.cadastroaluno.service.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class CadastroAlunoController {

    private final AlunoService alunoService;

    @Autowired
    public CadastroAlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Aluno aluno) {
        Integer id = alunoService.addAluno(aluno);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Aluno> findAll(
            @RequestParam(required = false) String aluno,
            @RequestParam(required = false) Integer idade) {
        return alunoService.findAllAlunos(aluno, idade);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable("id") Integer id) {
        Aluno aluno = alunoService.findAlunoById(id);
        return new ResponseEntity<>(aluno, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable("id") Integer id, @RequestBody Aluno alunoAtualizado) {
        Aluno alunoUpdated = alunoService.updateAluno(id, alunoAtualizado);
        return new ResponseEntity<>(alunoUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        alunoService.deleteAluno(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}