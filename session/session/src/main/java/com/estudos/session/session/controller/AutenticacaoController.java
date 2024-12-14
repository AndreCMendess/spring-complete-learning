package com.estudos.session.session.controller;

import com.estudos.session.session.Model.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AutenticacaoController {
    @RequestMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/autentica")
    public String autenticar(HttpServletRequest request, Usuario usuario) {
        HttpSession session = request.getSession();
        if (session != null && usuario.getLogin().equals("adm") && usuario.getSenha().equals("123456789")) {
            session.setAttribute("usuario", usuario.getLogin());
            return "protegido";
        }
        return "login";
    }

    @RequestMapping("/protegido")
    public ModelAndView acessarPaginaProtegida(HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session != null && session.getAttribute("usuario") != null && session.getAttribute("usuario").equals("adm")){
            return new ModelAndView("protegido");
        }
        return new ModelAndView("redirect:/");

    }

    @RequestMapping("/logoff")
    public ModelAndView Logoff(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }
         return new ModelAndView("redirect:/");
    }

}

