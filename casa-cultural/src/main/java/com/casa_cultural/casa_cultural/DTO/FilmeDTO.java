package com.casa_cultural.casa_cultural.DTO;

import com.casa_cultural.casa_cultural.model.Filme;
import jakarta.validation.constraints.NotBlank;


public class FilmeDTO {

    private Integer id;
    @NotBlank(message="Titulo obrigatório")
    private String titulo;
    @NotBlank(message="Sinopse obrigatório")
    private String sinopse;
    @NotBlank(message="Genero obrigatório")
    private String genero;
    private String anoLancamento;

    public FilmeDTO(Filme filme) {
        this.id = filme.getId();
        this.titulo = filme.getTitulo();
        this.sinopse = filme.getSinopse();
        this.genero = filme.getGenero();
        this.anoLancamento = filme.getAnoLancamento();
    }

    public FilmeDTO() {
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

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
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
}
