package com.casa_cultural.casa_cultural.DTO;

public class FilmeDTO {
    private Integer id;
    private String titulo;
    private double mediaNota;

    public FilmeDTO(Integer id, String titulo,double mediaNota) {
        this.id = id;
        this.mediaNota = mediaNota;
        this.titulo = titulo;
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

    public double getMediaNota() {
        return mediaNota;
    }

    public void setMediaNota(double mediaNota) {
        this.mediaNota = mediaNota;
    }
}
