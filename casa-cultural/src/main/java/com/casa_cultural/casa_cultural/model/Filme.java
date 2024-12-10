
package com.casa_cultural.casa_cultural.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Analise")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String titulo;
    private String sinopse;
    private String genero;
    private String anoLancamento;
    @OneToMany(mappedBy = "filme" ,cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Analise> analise = new ArrayList();

}
