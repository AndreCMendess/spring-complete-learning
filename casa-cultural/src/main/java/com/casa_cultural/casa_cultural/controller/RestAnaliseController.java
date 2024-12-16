package com.casa_cultural.casa_cultural.controller;

import com.casa_cultural.casa_cultural.model.Analise;
import com.casa_cultural.casa_cultural.service.AnaliseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/filmes/analises")
@RestController
public class RestAnaliseController {

    @Autowired
    AnaliseService analiseService;

    @GetMapping
    public ResponseEntity<List> receberAnalises(){
        List<Analise> analises = analiseService.retornaTodasAnalises();
        return new ResponseEntity<>(analises, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List> obterAnalisePorFilme(@PathVariable Integer id){
        List<Analise> analisesFilme = analiseService.retornarAnalisePorIdFilme(id);
        return new ResponseEntity<>(analisesFilme, HttpStatus.OK);
    }


    @PostMapping("/{filmeId}")
    public ResponseEntity<Analise> adicionarAnalis(@PathVariable Integer filmeId, @RequestBody Analise analise){
        Analise novaAnalise =  analiseService.adicionarAnalise(analise,filmeId);
        return new ResponseEntity<>(novaAnalise,HttpStatus.OK);
    }

    @PutMapping("/{analiseId}")
    public  ResponseEntity<Analise> atualizarAnalise(@PathVariable Integer analiseId,@RequestBody Analise analise){
        Analise analiseAtualizada = analiseService.atualizarAnalise(analiseId,analise);
        return new ResponseEntity<>(analiseAtualizada,HttpStatus.OK);
    }

    @DeleteMapping("/{filmeId}/analises/{analiseId}")
    public ResponseEntity deletarAnalise(@PathVariable Integer filmeId,@PathVariable Integer analiseId){
         analiseService.deletarAnalise(filmeId,analiseId);
         return new ResponseEntity(HttpStatus.OK);
    }

}
