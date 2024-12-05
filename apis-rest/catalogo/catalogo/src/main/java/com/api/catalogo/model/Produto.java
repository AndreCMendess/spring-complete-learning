
package com.api.catalogo.model;

import org.springframework.stereotype.Component;

@Component
public class Produto {
    private long id;
    private String descricao;
    private char tamanho;
    private double valor;
    private boolean status;

    public Produto(long id, String descricao, char tamanho, double valor, boolean status) {
        this.id = id;
        this.descricao = descricao;
        this.tamanho = tamanho;
        this.valor = valor;
        this.status = status;
    }

    public Produto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getTamanho() {
        return tamanho;
    }

    public void setTamanho(char tamanho) {
        this.tamanho = tamanho;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
    
    
}
