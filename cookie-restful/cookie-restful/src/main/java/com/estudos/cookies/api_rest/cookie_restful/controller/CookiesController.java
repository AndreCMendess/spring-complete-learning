package com.estudos.cookies.api_rest.cookie_restful.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cookies")
public class CookiesController {

    @GetMapping("/gravar")
    public String registrarCookie(HttpServletResponse response){
        Cookie c = new Cookie("user-id","123abc");
        response.addCookie(c);
        return "Gravando cookie";
    }

    @GetMapping("/ler")
    public String lerCookie(@CookieValue(name="user-id",defaultValue = "nenhun-valor")String userId){
        return "cookie: " + userId;
    }
}
