package com.casa_cultural.casa_cultural.controller;

import com.casa_cultural.casa_cultural.model.Filme;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/filmes")
@RestController
public class RestFilmeController {

    @GetMapping
    public List<Filme>buscarFilmes() {
        return null;
    }

    @GetMapping("/{id}")
    public Filme buscarFilmePorId(@PathVariable int id) {
        return null;
    }

    @PostMapping
    public Filme adicionarFiflme(Filme novoFilme) {
        return novoFilme;
    }

    @PutMapping("/{id}")
    public Filme atualizarFilme(@PathVariable int id , @RequestBody Filme filmeAtualizado) {
        return filmeAtualizado;
    }

    @DeleteMapping("/{id}")
    public boolean deletarFilme(@PathVariable int id) {
        return true;
    }


}
