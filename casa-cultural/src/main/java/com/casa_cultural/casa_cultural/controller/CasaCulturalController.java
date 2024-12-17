package com.casa_cultural.casa_cultural.controller;

import com.casa_cultural.casa_cultural.model.Analise;
import com.casa_cultural.casa_cultural.model.Filme;
import com.casa_cultural.casa_cultural.service.AnaliseService;
import com.casa_cultural.casa_cultural.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CasaCulturalController {
    @Autowired
    FilmeService filmeService;
    @Autowired
    AnaliseService analiseService;

    @GetMapping("/")
    public String paginaInicial(Model model){
        double media= 0;

        model.addAttribute("listarFilmes",filmeService.getTodosFilmes());

        model.addAttribute("mediaNota",media);
        return "pagina-inicial";
    }

    @GetMapping("/lista-filmes")
    public String listarFilmesEanalises(Model model){
        Analise analise = new Analise();
        model.addAttribute("listarFilmes",filmeService.getTodosFilmes());
        model.addAttribute("analise",analise);
        return "filmes";
    }

    /*@PostMapping("/lista-filmes")
    public String adicionarAnalise(@ModelAttribute("analise") Analise analise, BindingResult result){
        if(result.hasErrors()){
            return "filmes";
        }


        if(analise.getId() == null){
            analiseService.adicionarAnalise(analiseDTO,analise.getFilme().getId());
        }else{
            analiseService.atualizarAnalise(analise.getId(),analise);
        }
        return "redirect:/";
    }*/


    @GetMapping("/deletarFilme/{id}")
    public String deletarFilme(@PathVariable(value="id") Integer id){
        try {

            filmeService.deletarFilme(id);
            return "filmes";
        } catch (NumberFormatException e) {
            return "redirect:/erro";
        }
    }

    @GetMapping("/cadastrar-filme")
    public String criarFilmeForm(Model model){
        Filme filme = new Filme();
        model.addAttribute("filme",filme);
        return "cadastrar-filme";
    }


    @PostMapping("/cadastrar-filme")
    public String adicionarFilme(@ModelAttribute("filme") Filme filme, BindingResult result){
        if(result.hasErrors()){
            return "cadastrar-filme";
        }


        if(filme.getId() == null){
            filmeService.adicionandoFilme(filme);
        }else{
            filmeService.atualizarFilme(filme.getId(),filme);
        }
        return "redirect:/";
    }

    @GetMapping("/atualizarFilmeForm/{id}")
    public String atualizarFIlme(@PathVariable(value="id") Integer id,Model model){
        Filme filme = filmeService.getFilmePorId(id);
        model.addAttribute("filme",filme);
        return "atualizar-filme";
    }

    @PostMapping("/atualizarFilmeForm/{id}")
    public String atualizarFilme(@PathVariable(value="id") Integer id, @ModelAttribute Filme filme, BindingResult result){
        if(result.hasErrors()) {
            return "atualizar-filme";
        }

        filme.setId(id);
        filmeService.atualizarFilme(id, filme);
        return "redirect:/lista-filmes";
    }


}
