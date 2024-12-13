package com.casa_cultural.casa_cultural.service;

import com.casa_cultural.casa_cultural.model.Filme;
import com.casa_cultural.casa_cultural.repository.AnaliseRepository;
import com.casa_cultural.casa_cultural.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {
    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    AnaliseRepository analiseRepository;

    public Filme adicionandoFilme(Filme filme){
        filme.setId(null);
        filmeRepository.save(filme);
        return filme;
    }

    public Filme atualizarFilme(Integer filmeId , Filme filmeAtualizado){
        Filme filme = filmeRepository.findById(filmeId).orElse(null);
        filme.setTitulo(filmeAtualizado.getTitulo());
        filme.setSinopse(filmeAtualizado.getSinopse());
        filme.setGenero(filmeAtualizado.getGenero());
        filme.setAnoLancamento(filmeAtualizado.getAnoLancamento());
        filmeRepository.save(filme);
        return filme;
    }

    public Filme getFilmePorId(Integer id){
        return filmeRepository.findById(id).orElse(null);
    }

    public List<Filme> getTodosFilmes(){
        return filmeRepository.findAll();
    }

    public boolean deletarFilme(Integer id) {
        if (filmeRepository.existsById(id)) {
            filmeRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
