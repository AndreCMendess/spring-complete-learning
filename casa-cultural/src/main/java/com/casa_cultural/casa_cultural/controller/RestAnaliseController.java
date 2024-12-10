package com.casa_cultural.casa_cultural.controller;

import com.casa_cultural.casa_cultural.model.Analise;
import com.casa_cultural.casa_cultural.model.Filme;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/filmes/{id}/analises")
@RestController
public class RestAnaliseController {

    @GetMapping
    public List<Analise> receberAnalises(@PathVariable int filmeId){
        return null;
    }

    @PostMapping
    public Analise adicionarAnalis(@PathVariable Integer filmeId, @RequestBody Analise analise){
        return null;
    }

    @PutMapping("{/analiseId}")
    public Analise atualizarAnalise(@PathVariable Integer filmeId, @PathVariable int analiseId,@RequestBody Analise analise){
        return null;
    }

    @DeleteMapping("/{filmeId}")
    public boolean deletarAnalise(@PathVariable Filme filmeId,@PathVariable Integer analiseId){
        return false;
    }

}
