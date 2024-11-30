package com.casa_cultural.casa_cultural.model;

public class Analise {
    private int id;
    private Filme filme;
    private double nota;

    public Analise(int id, Filme filme, double nota) {
        this.id = id;
        this.filme = filme;
        this.nota = nota;
    }

    public Analise() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    
}
