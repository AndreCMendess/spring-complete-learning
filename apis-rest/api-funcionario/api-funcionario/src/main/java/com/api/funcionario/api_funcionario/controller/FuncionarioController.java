package com.api.funcionario.api_funcionario.controller;

import com.api.funcionario.api_funcionario.model.Funcionario;
import com.api.funcionario.api_funcionario.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Funcionario> addFuncionario(@Valid @RequestBody Funcionario funcionario){
        System.out.println("Requisição recebida: " + funcionario);
        var novoFuncionario = funcionarioService.criarFuncionario(funcionario);
        return new ResponseEntity<>(novoFuncionario,HttpStatus.CREATED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable Integer id,@RequestBody Funcionario funcionario){
        var funcionarioAtualiado = funcionarioService.atualizarFuncionario(id,funcionario);
        return new ResponseEntity<>(funcionarioAtualiado,HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarFuncinoario(@PathVariable Integer id){
        funcionarioService.deletarFuncionario(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/pesquisar-nome/{nome}")
    public ResponseEntity<List> getPesquisarPorNomeFuncionario(@PathVariable String nome){
        List<Funcionario> funcionarios = funcionarioService.getFuncionarioPorNome(nome);
        return new ResponseEntity<>(funcionarios,HttpStatus.OK);
    }

    @GetMapping("/maior-salario")
    public ResponseEntity<Funcionario> getMaiorSalario(){
        Funcionario funcionario = funcionarioService.getMaiorSalario();
        return new ResponseEntity<>(funcionario,HttpStatus.OK);
    }



}
