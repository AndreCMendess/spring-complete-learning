package com.casa_cultural.casa_cultural.controller;

import com.casa_cultural.casa_cultural.model.Analise;
import com.casa_cultural.casa_cultural.model.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmeController {
    @GetMapping("/pagina-inicial")
    public String paginaInicial(Model model){
        Filme filme = new Filme(1, "Filme 1", "filme sinopse","aventura","2020");
        Analise analise = new Analise(1,filme,5.0);
        model.addAttribute("filme",filme);
        model.addAttribute("analise",analise);
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
