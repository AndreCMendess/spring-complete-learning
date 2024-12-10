package com.casa_cultural.casa_cultural.service;

import com.casa_cultural.casa_cultural.model.Analise;
import com.casa_cultural.casa_cultural.model.Filme;
import com.casa_cultural.casa_cultural.repository.AnaliseRepository;
import com.casa_cultural.casa_cultural.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnaliseService {
    @Autowired
    AnaliseRepository analiseRepository;

    @Autowired
    FilmeRepository filmeRepository;

    public Analise adicionarAnalise(Analise analise,Integer filmeId){
       analise.setId(null);
       Filme filme = filmeRepository.getReferenceById(filmeId);
       filme.getAnalise().add(analise);
       analise.setFilme(filme);
       analiseRepository.save(analise);
       filmeRepository.save(filme);
       return analise;
    }

    public Analise atualizarAnalise(Integer filmeId,Integer analiseId,Analise analiseAtualizada){
        Analise analise = buscarAnalisePorId(analiseId);
        Filme filme = filmeRepository.getReferenceById(filmeId);

        if(filme.getAnalise().contains(analise)) {
            analise.setAnalise(analiseAtualizada.getAnalise());
            analise.setNota(analiseAtualizada.getNota());
            return analise;
        }
        return null;

    }

    public Analise buscarAnalisePorId(Integer analiseId){
        Analise analise = analiseRepository.findById(analiseId).orElse(null);
        return analise;
    }

    public List<Analise> retornaTodasAnalises(){
        return analiseRepository.findAll();
    }

    public boolean deletarAnalise(Integer filmeId , Integer analiseId){
        Filme filme = filmeRepository.findById(filmeId).orElse(null);
        Analise analise = buscarAnalisePorId(analiseId);

        if(filme.getAnalise().contains(analise)){
            filme.getAnalise().remove(analise);

            filmeRepository.save(filme);
            analiseRepository.deleteById(analise.getId());
            return true;
        }
        return false;
    }


}
