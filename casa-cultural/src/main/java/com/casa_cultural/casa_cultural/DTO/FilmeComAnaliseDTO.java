package com.casa_cultural.casa_cultural.DTO;

import java.util.List;

public class FilmeComAnaliseDTO {
    private Integer id;
    private String titulo;
    private String sinopse;
    private String genero;
    private String anoLancamento;
    private List<AnaliseDTO> analises;
    private Double mediaNota;

    public FilmeComAnaliseDTO(Integer id, String titulo, String sinopse, String genero, String anoLancamento, List<AnaliseDTO> analises, Double mediaNota) {
        this.id = id;
        this.titulo = titulo;
        this.sinopse = sinopse;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
        this.analises = analises;
        this.mediaNota = mediaNota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public String getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(String anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public List<AnaliseDTO> getAnalises() {
        return analises;
    }

    public void setAnalises(List<AnaliseDTO> analises) {
        this.analises = analises;
    }

    public Double getMediaNota() {
        return mediaNota;
    }

    public void setMediaNota(Double mediaNota) {
        this.mediaNota = mediaNota;
    }
}