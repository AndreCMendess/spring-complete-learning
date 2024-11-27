package com.springmvc.projetoMVC.controller;
import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MiscController {
    
    @GetMapping("/inicio")
    public String mostrarMensagemInicio(){
        return "paginaInicial";
    }
    
    @GetMapping("/produtos")
    public String mostrarCatalagoProdutos(){
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
    
}
