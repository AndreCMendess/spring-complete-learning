
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

    public double calcularMedia(){

        if(analises == null){
            return 0.0;
        }else{
            return analises.stream()//Itera a Lista de analises
                            .mapToDouble(Analise::getNota)//Obtem a nota de todas as analises
                            .average()//Calcula a media das notas obtidas
                    .orElse(0.0);//Retorna 0.0 se estiver vazio

        }


    }

}
