package com.casa_cultural.casa_cultural.model;

import java.util.ArrayList;
import java.util.List;

public class FilmeRepository {
    private List<Filme> filmes = new ArrayList<>();
    private int idContador = 1;
    
    public Filme cadastrarFilme(Filme filme){
        idContador++;
        filme.setId(idContador);
        filmes.add(filme);
        
        return filme;
    }
    
    public List<Filme> filmesCadastrados(){
        return filmes;
    }
}
