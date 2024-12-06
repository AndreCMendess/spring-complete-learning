package com.api.funcionario.api_funcionario.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String cpf;
    private String nome;
    private String telefone;
    private String email;
    private double salario;

}
