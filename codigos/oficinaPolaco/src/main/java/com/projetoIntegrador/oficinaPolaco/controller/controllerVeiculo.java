package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.Cliente;
import com.projetoIntegrador.oficinaPolaco.model.Dados;
import com.projetoIntegrador.oficinaPolaco.model.Veiculo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controllerVeiculo {
       
    @GetMapping("/inserirVeiculo")
    public String mostraVeiculo(Model model){
        model.addAttribute("veiculo", new Veiculo());
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("clientes", Dados.listarVeiculos());
        return "veiculo";
    }
    
    @GetMapping("/buscarClienteCpf")
    public String buscaClienteCpf(Model model, @RequestParam String cpf){
        model.addAttribute("cliente", Dados.buscaClienteCpf(cpf));
        return "veiculo";
    }
}
