package com.casa_cultural.casa_cultural.controller;

import com.casa_cultural.casa_cultural.model.Analise;
import com.casa_cultural.casa_cultural.model.Filme;
import com.casa_cultural.casa_cultural.model.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilmeController {
    
    @Autowired
    FilmeRepository filmeRepository;
    
    @GetMapping("/pagina-inicial")
    public String paginaInicial(Model model){
        model.addAttribute("filmes",filmeRepository.filmesCadastrados());
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
