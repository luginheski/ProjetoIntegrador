
package com.projetoIntegrador.oficinaPolaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllerOrcamento {
    
    @GetMapping("/orcamentos")
    public String mostraOS(){
        return "orcamentos";
    }
}
