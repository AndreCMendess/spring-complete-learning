package com.casa_cultural.casa_cultural.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class FilmeRepository {
    private List<Filme> filmes = new ArrayList<>();
    private int idContador = 0;
    
    public Filme cadastrarFilme(Filme filme){
        idContador++;
        filme.setId(idContador);
        filmes.add(filme);
        
        return filme;
    }
    
    public List<Filme> filmesCadastrados(){
        return filmes;
    }
    
    
    public void avaliarFilme(int id,Analise analise){
        id = analise.getFilme().getId();
      
        Filme filme = null;
        for (Filme f : this.filmesCadastrados()) {
            if (f.getId() == id) {
                filme = f;
                break;  
            }
        }

        if (filme != null) {
            List<Analise> analises = filme.getAnalise();
            analises.add(analise);
            filme.setAnalise(analises);
        } else {
            System.out.println("Filme não encontrado para o ID: " + id);
        }
    }
}
