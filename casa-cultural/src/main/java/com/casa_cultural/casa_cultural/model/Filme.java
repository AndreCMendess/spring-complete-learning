
package com.casa_cultural.casa_cultural.model;

import java.util.ArrayList;
import java.util.List;


public class Filme {
    private int id;
    private String titulo;
    private String sinopse;
    private String genero;
    private String anoLancamento;
    private List<Analise> analise = new ArrayList();

    public Filme(int id, String titulo, String sinopse, String genero, String anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }

    public List<Analise> getAnalise() {
        return analise;
    }

    public void setAnalise(List<Analise> analise) {
        this.analise = analise;
    }

    
    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    } 

    public Filme() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
    
    public double mediaNota(){
        double totalAnalise = 0;
        double media = 0;
        
        for(int i=0; i<analise.size(); i++){
            totalAnalise  += analise.get(i).getNota();
            media = totalAnalise / analise.size();
        }
        
        return media; 
    }
    
}
