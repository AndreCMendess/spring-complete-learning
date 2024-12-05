
package com.api.catalogo.controller;

import com.api.catalogo.model.Produto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/catalogo")
public class ProdutoController {
    
    private List<Produto> produtos = new ArrayList<>();
    private long proximoId = 1L;
    
    @GetMapping("")
    public List buscarTodosProdutos(){
        return produtos;
    }
    
    @GetMapping("/{id}")
    public Produto buscarProdutoPorID(@PathVariable int id){
        for(Produto produto : produtos){
            if(produto.getId() == id){
                return produto;
            }
        }
        return null;    
    }
    
    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto){
        long id = produtos.size() + 1L;
        produto.setId(id);
        produtos.add(produto);
        return produto;
    }
    
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable long id , @RequestBody Produto produtoAtualizado){  
        for(int i=0; i<produtos.size(); i++){
            Produto produto = produtos.get(i);
            if(produto.getId() == id){
                produto.setDescricao(produtoAtualizado.getDescricao());
                produto.setValor(produtoAtualizado.getValor());
                return produto;
            }  
        }
        return null;
    }
    
    @DeleteMapping("/{id}")
    public boolean deletarProduto(@PathVariable long id){
         for(int i=0; i<produtos.size(); i++){
             Produto produto = produtos.get(i);
             if(produto.getId() == id){
                 produtos.remove(i);
                 return true;
             }
         }
         return false;
    }
    
    
    
}
