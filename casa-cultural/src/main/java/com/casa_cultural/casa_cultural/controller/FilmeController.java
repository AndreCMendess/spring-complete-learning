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
    public String paginaFilmes(Model model) {
        Filme filme1 = new Filme(1, "O Senhor dos Anéis: A Sociedade do Anel", "A jornada de um hobbit para destruir um anel mágico e salvar o mundo.", "Aventura/Fantasia", "2001");
        Analise analise1 = new Analise(1, filme1, "Excelente! Uma das melhores adaptações de livro.", 5.0);

        Filme filme2 = new Filme(2, "Inception", "Um ladrão especializado em extrair segredos do subconsciente é dado uma tarefa impossível: implantar uma ideia na mente de alguém.", "Ficção Científica/Ação", "2010");
        Analise analise2 = new Analise(2, filme2, "Intrigante e visualmente impressionante.", 4.5);

        Filme filme3 = new Filme(3, "Matrix", "Um hacker descobre a verdade sobre o mundo em que vive e seu papel em uma revolução contra as máquinas.", "Ação/Ficção Científica", "1999");
        Analise analise3 = new Analise(3, filme3, "Revolucionário! Uma obra-prima do cinema.", 5.0);

        Filme filme4 = new Filme(4, "O Rei Leão", "A história de um leão jovem que enfrenta desafios enquanto se torna o rei de sua terra.", "Animação/Infantil", "1994");
        Analise analise4 = new Analise(4, filme4, "Emocionante e visualmente deslumbrante", 6.0);

        filme1.getAnalise().add(analise1);
        filme2.getAnalise().add(analise2);
        filme3.getAnalise().add(analise3);
        filme4.getAnalise().add(analise4);
        
        filmeRepository.cadastrarFilme(filme1);
        filmeRepository.cadastrarFilme(filme2);
        filmeRepository.cadastrarFilme(filme3);
        filmeRepository.cadastrarFilme(filme4);

        model.addAttribute("filmes", filmeRepository.filmesCadastrados());
        return "filmes";
    }

    @GetMapping("/cadastrar-filme")
    public String cadastrarFilme(){
        return "cadastrar-filme";
    }
}
