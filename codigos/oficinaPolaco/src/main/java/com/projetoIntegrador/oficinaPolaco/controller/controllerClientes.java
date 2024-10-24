
package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.Cliente;
import com.projetoIntegrador.oficinaPolaco.model.Dados;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class controllerClientes {
       @GetMapping("/cliente")
    public String mostraCliente(){
        return "cliente";
    }
    
        @PostMapping("/cadastroCliente")
    public String processarFilme(Model model, @ModelAttribute Cliente cliente) {
        Dados.adicionarCliente(cliente);        
        return "redirect:/listar";
    }
}
