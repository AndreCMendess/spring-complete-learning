package com.casa_cultural.casa_cultural.DTO;

import lombok.Getter;

@Getter
public class AnaliseDTO {
    private Integer filmeId;
    private String comentario;
    private double nota;

    public AnaliseDTO(Integer filmeId, String comentario, double nota) {
        this.filmeId = filmeId;
        this.comentario = comentario;
        this.nota = nota;
    }

    public AnaliseDTO() {

    }

    public void setFilmeId(Integer filmeId) {
        this.filmeId = filmeId;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
