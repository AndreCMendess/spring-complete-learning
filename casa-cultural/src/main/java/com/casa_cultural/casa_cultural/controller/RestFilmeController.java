package com.casa_cultural.casa_cultural.controller;

import com.casa_cultural.casa_cultural.model.Filme;
import com.casa_cultural.casa_cultural.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/filmes")
@RestController
public class RestFilmeController {

    @Autowired
    FilmeService filmeService;

    @GetMapping
    public List<Filme>buscarFilmes() {
        return filmeService.getTodosFilmes();
    }

    @GetMapping("/{id}")
    public Filme buscarFilmePorId(@PathVariable int id) {
        return filmeService.getFilmePorId(id);
    }

    @PostMapping
    public Filme adicionarFiflme(Filme novoFilme) {
        return filmeService.adicionandoFilme(novoFilme);
    }

    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable int id , @RequestBody Filme filmeAtualizado) {
        return filmeService.atualizarFilme(id,filmeAtualizado);
    }

    @DeleteMapping("/{id}")
    public boolean deletarFilme(@PathVariable int id) {
        List<Filme> filmes = filmeService.getTodosFilmes();
        for(Filme f : filmes){
            if(f.getId() == id){
                filmeService.deletarFilme(id);
                return true;
            }
        }
        return false;
    }


}
