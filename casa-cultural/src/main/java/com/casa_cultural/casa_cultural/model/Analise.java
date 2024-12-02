package com.casa_cultural.casa_cultural.model;

public class Analise {
    private int id;
    private Filme filme;
    private String analise;
    private double nota;

    public Analise(int id, Filme filme, String analise, double nota) {
        this.id = id;
        this.filme = filme;
        this.analise = analise;
        this.nota = nota;
    }

    public String getAnalise() {
        return analise;
    }

    public void setAnalise(String analise) {
        this.analise = analise;
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
