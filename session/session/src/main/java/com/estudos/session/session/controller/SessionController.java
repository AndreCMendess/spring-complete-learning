package com.estudos.session.session.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sessao")
public class SessionController {
    @RequestMapping("/gravar")
    public String gravarSessao(HttpServletRequest request, Model model, String nome){
        HttpSession sessao = request.getSession();
        if(sessao != null){
            sessao.setAttribute("nome-usuario",nome);
            model.addAttribute("mensagem","Gravando sessão[nome]");
        }else{
            model.addAttribute("mensagem", "Sessão Nula");
        }
        return "sessao";
    }

    @RequestMapping("/ler")
    public String lerSessao(HttpServletRequest request, Model model){
        HttpSession sessao = request.getSession();
        String nome = "";
        if(sessao != null && sessao.getAttribute("nome-usuario") != null)
            nome = (String) sessao.getAttribute("nome-usuario");
            model.addAttribute("mensagem", "Sessao[nome] = " + nome);
             return "sessao";
    }


}
