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
    public Filme buscarFilmePorId(@PathVariable Integer id) {
        return filmeService.getFilmePorId(id);
    }

    @PostMapping("/adicionar")
    public Filme adicionarFiflme(@RequestBody Filme novoFilme) {
        return filmeService.adicionandoFilme(novoFilme);
    }

    @PutMapping("/filmes/{id}")
    public Filme atualizarFilme(@PathVariable Integer id , @RequestBody Filme filmeAtualizado) {
        return filmeService.atualizarFilme(id,filmeAtualizado);
    }

    @DeleteMapping("/{id}")
    public boolean  deletarFilme(@PathVariable Integer id) {
        return filmeService.deletarFilme(id);

    }


}
