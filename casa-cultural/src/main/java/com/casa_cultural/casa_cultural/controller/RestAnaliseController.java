package com.casa_cultural.casa_cultural.controller;

import com.casa_cultural.casa_cultural.model.Analise;
import com.casa_cultural.casa_cultural.service.AnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/filmes/{id}/analises")
@RestController
public class RestAnaliseController {

    @Autowired
    AnaliseService analiseService;

    @GetMapping
    public List<Analise> receberAnalises(@PathVariable int filmeId){
        return analiseService.retornaTodasAnalises();
    }

    @PostMapping
    public Analise adicionarAnalis(@PathVariable Integer filmeId, @RequestBody Analise analise){
        return analiseService.adicionarAnalise(analise,filmeId);
    }

    @PutMapping("/{analiseId}")
    public Analise atualizarAnalise(@PathVariable Integer filmeId, @PathVariable Integer analiseId,@RequestBody Analise analise){
        return analiseService.atualizarAnalise(filmeId,analiseId,analise);
    }

    @DeleteMapping("/{filmeId}")
    public boolean deletarAnalise(@PathVariable Integer filmeId,@PathVariable Integer analiseId){
        return analiseService.deletarAnalise(filmeId,analiseId);
    }

}
