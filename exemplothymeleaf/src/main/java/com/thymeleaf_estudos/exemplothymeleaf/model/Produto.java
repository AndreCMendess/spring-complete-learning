package com.thymeleaf_estudos.exemplothymeleaf.model;

import java.util.logging.Logger;

public class Produto {
    private int id;
    private String descricao;
    private boolean status;

    public Produto() {
    }

    public Produto(int id, String descricao, boolean status) {
        this.id = id;
        this.descricao = descricao;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
 
    
    

   
    
    
    
    
    
}
