package com.casa_cultural.casa_cultural.controller;

import com.casa_cultural.casa_cultural.DTO.FilmeComAnaliseDTO;
import com.casa_cultural.casa_cultural.DTO.FilmeDTO;
import com.casa_cultural.casa_cultural.model.Filme;
import com.casa_cultural.casa_cultural.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/filmes")
@RestController
public class RestFilmeController {

    @Autowired
    FilmeService filmeService;

    @GetMapping
    public ResponseEntity<List>buscarFilmes() {
        List<Filme> filmes = filmeService.getTodosFilmes();
        return new ResponseEntity<>(filmes, HttpStatus.OK);
    }

    @GetMapping("/tabela-inicio")
    public ResponseEntity<List<FilmeDTO>> getFilmesDTO(){
        List<FilmeDTO> filmesDTO = filmeService.getFilmesDTO();
        return new ResponseEntity<>(filmesDTO,HttpStatus.OK);
    }



    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarFilmePorId(@PathVariable Integer id) {
        Filme filme = filmeService.getFilmePorId(id);
        return new ResponseEntity<>(filme,HttpStatus.OK);
    }

    @PostMapping("/adicionar")
    public ResponseEntity<Filme> adicionarFilme(@RequestBody Filme filme) {
        var novoFilme = filmeService.adicionandoFilme(filme);
        return new ResponseEntity<>(novoFilme,HttpStatus.OK);
    }

    @PutMapping("/filmes/{id}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable Integer id , @RequestBody Filme filme) {
        var filmeAtualizado = filmeService.atualizarFilme(id,filme);
        return new ResponseEntity<>(filmeAtualizado,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarFilme(@PathVariable Integer id) {
        filmeService.deletarFilme(id);
        return new ResponseEntity(HttpStatus.OK);

    }

    @GetMapping("/filmes-analises")
    public ResponseEntity<List<FilmeComAnaliseDTO>> getFilmesComAnalisesDTO(){
        List<FilmeComAnaliseDTO> filmesDTO = filmeService.getFilmesComAnaliseDTO();
        return new ResponseEntity<>(filmesDTO,HttpStatus.OK);
    }




}
