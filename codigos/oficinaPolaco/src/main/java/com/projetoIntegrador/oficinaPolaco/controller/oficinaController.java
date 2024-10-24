package com.projetoIntegrador.oficinaPolaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class oficinaController {
    
   
    
    
    
 
    
    @GetMapping("/veiculo")
    public String mostraVeiculo(){
        return "veiculo";
    }
}
