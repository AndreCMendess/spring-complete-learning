package com.casa_cultural.casa_cultural.model;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FilmeRepositoryy {
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
            List<Analise> analises = filme.getAnalises();
            analises.add(analise);
            filme.setAnalises(analises);
        } else {
            System.out.println("Filme não encontrado para o ID: " + id);
        }
    }
}
