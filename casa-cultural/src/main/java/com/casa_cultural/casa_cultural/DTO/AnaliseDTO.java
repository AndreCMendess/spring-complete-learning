package com.casa_cultural.casa_cultural.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class AnaliseDTO {
    @NotNull
    private Integer filmeId;
    @NotBlank
    private String comentario;
    @NotBlank
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
