package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.Cliente;
import com.projetoIntegrador.oficinaPolaco.model.Dados;
import com.projetoIntegrador.oficinaPolaco.model.Veiculo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controllerVeiculo {
       
    @GetMapping("/inserirVeiculo")
    public String mostraVeiculo(Model model, @RequestParam String id){
        Integer idCliente = Integer.parseInt(id);
        Cliente clienteEncontrado = new Cliente();
        clienteEncontrado = Dados.obtemCliente(idCliente);
        
        List<Veiculo> veiculoEncontrado = new ArrayList<>();
        veiculoEncontrado = Dados.listaVeiculo(idCliente);
        model.addAttribute("cliente", clienteEncontrado);
        model.addAttribute("veiculos", veiculoEncontrado);
        model.addAttribute("veiculo", new Veiculo());
        return "veiculo";
    }
    
    @PostMapping("/guardarVeiculo")
    public String processarVeiculo(Model model, @ModelAttribute Veiculo veiculo, @ModelAttribute Cliente cliente){
        Dados.adicionaVeiculo(veiculo, cliente);
        return "redirect:/orcamentos";
    }
    
    @GetMapping("/listarVeiculo")
    public String mostraVeiculo(Model model) {
        model.addAttribute("veiculos", Dados.listarVeiculos());
        return "veiculo";
    }
    
    @GetMapping("/excluirVeiculo")
    public String excluirVeiculo(Model model, @RequestParam String id) {
        Integer idVeiculo = Integer.parseInt(id);
        Dados.excluirVeiculo(idVeiculo);
        return "redirect:/orcamentos";
    }
  
}