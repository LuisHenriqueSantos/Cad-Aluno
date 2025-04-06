package com.mentorama.cadastroaluno;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class CadastroAlunoController {
    
    private final List<Aluno> alunos;
    
    public CadastroAlunoController() {
        this.alunos = new ArrayList<Aluno>();
    }
    
    @PostMapping
    public ResponseEntity<Integer> add(@RequestBody final Aluno aluno){
        if(aluno.getId() == null){
            aluno.setId(alunos.size() + 1);
        }
        alunos.add(aluno);
        return new ResponseEntity<>(aluno.getId(), HttpStatus.CREATED) ;
    }

    @GetMapping
    public List<Aluno> findAll(
            @RequestParam(required = false) String aluno,
            @RequestParam(required = false) Integer idade) {

        return alunos.stream()
                .filter(alu -> (aluno == null || alu.getNome().contains(aluno)))
                .filter(alu -> (idade == null || alu.getIdade().equals(idade)))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Aluno findById(@PathVariable("id") Integer id){
        return this.alunos.stream()
                .filter(alu -> alu.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> update(@PathVariable("id") Integer id, @RequestBody Aluno alunoAtualizado) {
        Aluno alunoExistente = alunos.stream()
                .filter(alu -> alu.getId().equals(id))
                .findFirst()
                .orElse(null);
        
        if (alunoExistente == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        
        alunoExistente.setNome(alunoAtualizado.getNome());
        alunoExistente.setIdade(alunoAtualizado.getIdade());
        alunoExistente.setId(id);

        return new ResponseEntity<>(alunoExistente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Integer id){
        alunos.removeIf(alu -> alu.getId().equals(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
}
