package com.thymeleaf_estudos.exemplothymeleaf.controller;

import com.thymeleaf_estudos.exemplothymeleaf.model.Produto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();
    
    @GetMapping("/exibir-produto")
    public String exibirTarefa(Model model){
        String nome = "Lucas";
        Produto produto = new Produto(1, "Blusa Azul Nike", true);
        model.addAttribute("nome",nome);
        model.addAttribute("produto",produto);
        return "exibir-produtos";
        
    }
    
    @GetMapping("/catalago-produtos")
    public String exibirCatgalago(Model model) {
        model.addAttribute("produtos",produtos);
        return "catalago-produtos";
    }
    
    @GetMapping("/cadastro")
    public String exibirFormulario(Model model){
        model.addAttribute("produto",new Produto());
        return "cadastro-produto";
    }
    
     @PostMapping("/cadastro")
     public String processarFormulario(@ModelAttribute Produto produto, Model model){
         produto.setStatus(true);
         produtos.add(produto);
         model.addAttribute("produtos",produto);
         return "catalogo-produtos";
     }
 
   
   
}
