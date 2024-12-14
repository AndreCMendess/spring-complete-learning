package com.estudos.session.api_restful.session_api_rest.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sessoes")
public class SessaoController {
    @GetMapping("/gravar")
    public String gravarSessao(HttpServletRequest request, String nome){
        HttpSession session = request.getSession();
        if(session != null){
            session.setAttribute("usuario",nome);
            return "Sessão Atualizada";
        }
        return "Sem sessão";
    }

    @GetMapping("/ler")
    public String lerSessao(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session != null){
            return "Valor da Sessão: "+ (String) session.getAttribute("usuario");
        }
        return "Sen sessão";
    }

    @GetMapping("/excluir")
    public String excluirSessao(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session != null){
            session.invalidate();
        }
        return "excluido";
    }
}
