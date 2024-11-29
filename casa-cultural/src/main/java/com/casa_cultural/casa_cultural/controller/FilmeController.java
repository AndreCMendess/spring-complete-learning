package com.casa_cultural.casa_cultural.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmeController {
    @GetMapping("/pagina-inicial")
    public String paginaInicial(){
        return "pagina-inicial";
    }
    @GetMapping("/filmes")
    public String paginaFilmes(){
        return "filmes";
    }
    @GetMapping("/cadastrar-filme")
    public String cadastrarFilme(){
        return "cadastrar-filme";
    }
}
