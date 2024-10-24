
package com.projetoIntegrador.oficinaPolaco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controllerMenu {
    
     @GetMapping("/login")
    public String mostraLogin(){
        return "index";
    }
}
