package com.estudos.session.session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AutenticacaoController {
    @RequestMapping("/")
    public String index(){
        return "login";
    }


}
