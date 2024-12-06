package com.api.funcionario.api_funcionario.controller;

import com.api.funcionario.api_funcionario.model.Funcionario;
import com.api.funcionario.api_funcionario.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {
    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/listar")
    public ResponseEntity<List> getAllFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listarTodosFuncionarios();
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<Funcionario> getFuncionarioById(@PathVariable Integer id){
        Funcionario func = funcionarioService.getFuncionarioId(id);
        return new ResponseEntity<>(func,HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Funcionario> addFuncionario(@RequestBody Funcionario funcionario){
        var novoFuncionario = funcionarioService.criarFuncionario(funcionario);
        return new ResponseEntity<>(novoFuncionario,HttpStatus.CREATED);
    }

    @PutMapping("/atualizar/{ìd}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Integer id,@RequestBody Funcionario funcionario){
        var funcionarioAtualiado = funcionarioService.atualizarFuncionario(id,funcionario);
        return new ResponseEntity<>(funcionarioAtualiado,HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarFuncinoario(@PathVariable Integer id){
        funcionarioService.deletarFuncionario(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
