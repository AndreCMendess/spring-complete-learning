package com.springmvc.projetoMVC.controller;
import com.springmvc.projetoMVC.controller.model.Produto;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MiscController {
    
    @GetMapping("/inicio")
    public String mostrarMensagemInicio(){
        return "paginaInicial";
    }
 
    @GetMapping("/produtos")
    public String mostrarCatalagoProdutos(Model model, String nome, String descricao, @RequestParam(defaultValue = "0") double valor) {
        Produto produto = new Produto();       
        produto.setNome(nome);        
        produto.setDescricao(descricao);
        produto.setValor(valor);     
        model.addAttribute("produto",produto);
        return "catalago";
    }
    
    @GetMapping("/diahora")
    public String mostrarDataEhora(Model model){
        LocalDateTime diaHora = LocalDateTime.now();
        model.addAttribute("data",diaHora.toLocalDate().toString());
        model.addAttribute("hora",diaHora.toLocalTime().toString());
        return "data";
    }
    
    @GetMapping("/temperatura")
    public String converterTemperatura(Model model, @RequestParam(defaultValue = "0") int valor){
        float farenheit,kelvin;
        kelvin = valor + 273;
        farenheit = 1.8f*valor + 32;
        model.addAttribute("celsius",valor);
        model.addAttribute("farenheit",farenheit);
        model.addAttribute("kelvin",kelvin);
        return "temperatura";
    }
    
    @GetMapping("/calculo")
    public String calcular(@RequestParam("valor1") int valor1, @RequestParam("valor2") int valor2, Model model) {
        double soma = valor1 + valor2;
        double subtracao = valor1 - valor2;
        double multiplicacao = valor1 * valor2;
        double divisao = valor1 != 0 ? valor1 / valor2 : 0;

        model.addAttribute("valor1",valor1);
        model.addAttribute("valor2",valor2);
        model.addAttribute("soma", soma);
        model.addAttribute("subtracao", subtracao);
        model.addAttribute("multiplicacao", multiplicacao);
        model.addAttribute("divisao", divisao);
        return "calculo";

    }
    
    @GetMapping("/cadastro")
    public String mostrarCadastro(Model model){
        model.addAttribute("produto",new Produto());
        return "cadastroProduto";
    }
    
    @PostMapping("/cadastro")
    public String recebeCadastro(Model model, @ModelAttribute Produto produto){
        model.addAttribute("produto",produto);
        return "catalago";
    }
    
    
   
    
    
}
