package com.estudos.cookies.cookie_mvc.controller;

import com.estudos.cookies.cookie_mvc.model.Preferencia;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SiteController {
    @RequestMapping("/preferencias")
    public String preferencias(){
        return "preferencias";
    }

    @PostMapping("/preferencias")
    public ModelAndView gravarPreferencias(@ModelAttribute Preferencia preferencia , HttpServletResponse response){
        Cookie cookiePrefNome = new Cookie("pref-nome",preferencia.getNome());
        cookiePrefNome.setDomain("localhost");
        cookiePrefNome.setHttpOnly(true);
        cookiePrefNome.setMaxAge(86400);
        response.addCookie(cookiePrefNome);

        Cookie cookiePrefEstilo = new Cookie("pref-estilo", preferencia.getEstilo());
        cookiePrefEstilo.setDomain("localhost");
        cookiePrefEstilo.setHttpOnly(true);
        cookiePrefEstilo.setMaxAge(86400);
        response.addCookie(cookiePrefEstilo);

        Cookie cookieFonte = new Cookie("pref-fonte",preferencia.getFonte());
        cookieFonte.setDomain("localhost");
        cookieFonte.setHttpOnly(true);
        cookieFonte.setMaxAge(86400);
        response.addCookie(cookieFonte);

        return new ModelAndView("redirect:/");
    }

    @RequestMapping("/")
    public String index(@CookieValue(name="pref-nome",defaultValue = "")String nome,
                        @CookieValue(name="pref-estilo",defaultValue="light-mode")String estilo,
                        @CookieValue(name="pref-fonte",defaultValue="new-roman")String fonte, Model model){
        model.addAttribute("nome",nome);
        model.addAttribute("css",estilo);
        model.addAttribute("fonte",fonte);
        return "index";
    }



}
