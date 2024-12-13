package com.casa_cultural.casa_cultural.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Analise")
public class Analise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name ="filme_id")
    @JsonBackReference
    private Filme filme;
    private String comentario;
    private double nota;

}
