package com.estudos.cookies.cookie_mvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Controller
@RequestMapping("/cookies")
public class CookiesController {

    @RequestMapping("/gravar")
    public String criarCookie(HttpServletResponse response){
        Cookie novoCookie = new Cookie("user-id","123abc");

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss", Locale.getDefault());
        String horas = now.format(formatter);
        Cookie horaCookie = new Cookie("horas",horas);
        novoCookie.setMaxAge(60 * 60);
        horaCookie.setMaxAge(60 * 60);
        novoCookie.setPath("/");
        horaCookie.setPath("/");
        response.addCookie(novoCookie);
        response.addCookie(horaCookie);
        return "cookies";
    }

    @RequestMapping("/ler")
    public String lerCookie(@CookieValue(name="user-id", defaultValue="nenhun-valor")String userId, Model model,
                            @CookieValue(name="horas", defaultValue="nenhun-valor")String horas)
    {
        System.out.println("User ID recebido: " + userId);
        System.out.println("Horas recebidas: " + horas);
        model.addAttribute("userId",userId);
        model.addAttribute("horas",horas);
        return "lerCookie";

    }

    @RequestMapping("/excluir")
    public String excluirCookie(HttpServletResponse response){
        Cookie novoCookie = new Cookie("user-id",null);
        novoCookie.setMaxAge(0);
        response.addCookie(novoCookie);
        return "excluirCookie";
    }


}
