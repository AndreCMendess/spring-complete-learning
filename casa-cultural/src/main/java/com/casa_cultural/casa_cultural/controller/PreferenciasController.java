package com.casa_cultural.casa_cultural.controller;

import com.casa_cultural.casa_cultural.model.Preferencia;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/site/preferencias")
public class PreferenciasController {

    @PostMapping
    public ResponseEntity<String> salvarPreferencia(@RequestBody Preferencia preferencias, HttpServletResponse response){
        Cookie temaCookie = new Cookie("tema",preferencias.getEstilo());
        temaCookie.setHttpOnly(true);
        temaCookie.setMaxAge(86400);
        temaCookie.setPath("/");
        temaCookie.setDomain("localhost");
        System.out.println("Tema carregado do cookie: " + preferencias.getEstilo());
        response.addCookie(temaCookie);
        return ResponseEntity.ok("Tema atualizado: " + preferencias.getEstilo());
    }

    @GetMapping
    public ResponseEntity<String> buscarPreferencia(@CookieValue(name="tema",defaultValue = "claro")String estilo){
        System.out.println("preferencia encontrado: " + estilo);
        return ResponseEntity.ok(estilo);
    }
}
