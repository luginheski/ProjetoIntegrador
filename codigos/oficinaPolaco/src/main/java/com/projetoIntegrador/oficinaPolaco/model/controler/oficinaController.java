package com.projetoIntegrador.oficinaPolaco.model.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class oficinaController {
    
    @GetMapping("/login")
    public String mostraLogin(){
        return "index";
    }
    
    @GetMapping("/orcamentos")
    public String mostraOS(){
        return "orcamentos";
    }

    
}
