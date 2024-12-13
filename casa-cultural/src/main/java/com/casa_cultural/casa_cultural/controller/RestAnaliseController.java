package com.casa_cultural.casa_cultural.controller;

import com.casa_cultural.casa_cultural.model.Analise;
import com.casa_cultural.casa_cultural.service.AnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/filmes/analises")
@RestController
public class RestAnaliseController {

    @Autowired
    AnaliseService analiseService;

    @GetMapping
    public List<Analise> receberAnalises(){
        return analiseService.retornaTodasAnalises();
    }

    @GetMapping("/{id}")
    List<Analise> obterAnalisePorFilme(@PathVariable Integer id){
        return analiseService.retornarAnalisePorIdFilme(id);
    }


    @PostMapping("/{filmeId}")
    public Analise adicionarAnalis(@PathVariable Integer filmeId, @RequestBody Analise analise){
        return analiseService.adicionarAnalise(analise,filmeId);
    }

    @PutMapping("/{analiseId}")
    public Analise atualizarAnalise(@PathVariable Integer analiseId,@RequestBody Analise analise){
        return analiseService.atualizarAnalise(analiseId,analise);
    }

    @DeleteMapping("/{filmeId}/analises/{analiseId}")
    public boolean deletarAnalise(@PathVariable Integer filmeId,@PathVariable Integer analiseId){
        return analiseService.deletarAnalise(filmeId,analiseId);
    }

}
