package com.api.funcionario.api_funcionario.service;


import com.api.funcionario.api_funcionario.exception.ResourceNotFoundException;
import com.api.funcionario.api_funcionario.model.Funcionario;
import com.api.funcionario.api_funcionario.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService  {

    @Autowired
    FuncionarioRepository funcionarioRepository;

    public Funcionario criarFuncionario(Funcionario funcionario){
        funcionario.setId(null);
        funcionarioRepository.save(funcionario);
        return funcionario;
    }

    public Funcionario atualizarFuncionario(Integer id, Funcionario funcionario){
        Funcionario func = getFuncionarioId(id);
        func.setNome(funcionario.getNome());
        func.setCpf(funcionario.getCpf());
        func.setTelefone(funcionario.getTelefone());
        func.setEmail(funcionario.getEmail());
        func.setSalario(funcionario.getSalario());
        funcionarioRepository.save(func);
        return func;
    }

    public Funcionario getFuncionarioId(Integer id){
        Funcionario funcionario = funcionarioRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Funcionario nao encontrado id: " + id));
        return funcionario;
    }

    public List<Funcionario> listarTodosFuncionarios(){
        return funcionarioRepository.findAll();
    }

    public void deletarFuncionario(Integer id){
        Funcionario func = getFuncionarioId(id);
        funcionarioRepository.deleteById(id);
    }
}
