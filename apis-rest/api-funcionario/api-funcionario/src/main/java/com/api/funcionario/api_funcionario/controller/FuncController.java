package com.api.funcionario.api_funcionario.controller;

import com.api.funcionario.api_funcionario.model.Funcionario;
import com.api.funcionario.api_funcionario.service.FuncionarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FuncController {
    @Autowired
    FuncionarioService funcionarioService;

    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listarFuncionarios",funcionarioService.listarTodosFuncionarios());
        return "index";
    }

    @GetMapping ("/deletarFuncionario/{id}")
    public String deletarFuncionario(@PathVariable(value="id") Integer id){
            funcionarioService.deletarFuncionario(id);
            return "redirect:/";
    }

    @GetMapping("/criarFuncionarioForm")
    public String criarFuncionarioForm(Model model){
        Funcionario funcionario = new Funcionario();
        model.addAttribute("funcionario",funcionario);
        return "inserir";
    }

    @PostMapping("/salvarFuncionario")
    public String salvarfuncionario(@Valid @ModelAttribute("funcionario") Funcionario func, BindingResult result){
        if(result.hasErrors()){
            return "inserir";
        }

        if(func.getId()==null){
            funcionarioService.criarFuncionario(func);
        }else{
            funcionarioService.atualizarFuncionario(func.getId(),func);
        }
        return "redirect:/";
    }

    @GetMapping("/atualizarFuncionarioForm/{id}")
    public String atualizarFuncionarioForm(@PathVariable(value="id") Integer id,Model model){
        Funcionario func = funcionarioService.getFuncionarioId(id);
        model.addAttribute("funcionario",func);
        return "atualizar";
    }

}
