package com.api.funcionario.api_funcionario.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.br.CPF;

@Data
@ToString
@Entity
@Table(name="Funcionario")
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Size(min=4,message="Informe ao menos 4 caracteres")
    private String nome;
    @NotBlank(message = "E-mail obrigatorio")
    private String email;
    @CPF(message="CPF INVALIDO")
    private String cpf;
    @NotBlank(message="Telefone obrigatório")
    private String telefone;
    @NotNull(message="Salário obrigatório")
    private double salario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
