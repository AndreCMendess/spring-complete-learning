
package com.casa_cultural.casa_cultural.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Filme")
public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String titulo;
    private String sinopse;
    private String genero;
    private String anoLancamento;
    @OneToMany(mappedBy = "filme" ,cascade = CascadeType.ALL, orphanRemoval = true ,fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Analise> analises = new ArrayList();


}
