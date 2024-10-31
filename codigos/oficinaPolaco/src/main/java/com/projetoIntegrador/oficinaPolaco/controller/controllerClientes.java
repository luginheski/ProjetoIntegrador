package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.Cliente;
import com.projetoIntegrador.oficinaPolaco.model.Dados;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controllerClientes {
        
    @GetMapping("/inserir-cliente")
    public String mostraCadastro(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente";
    }
     /*
    @GetMapping("/exibir")
    public String mostraDetalhes(Model model, @RequestParam String id) {
        Integer idCliente = Integer.parseInt(id);
        Cliente clienteEncontrado = new Cliente();
        clienteEncontrado = Dados.obtemCliente(idCliente);
        model.addAttribute("clientes", clienteEncontrado);
        return "exibir";
    }    */

    @PostMapping("/cadastroCliente")
    public String processarCliente(Model model, @ModelAttribute Cliente cliente) {
        Dados.adicionarCliente(cliente);
        return "redirect:/listar";
    }   
    
     @GetMapping("/listar")
    public String mostraCliente(Model model) {
        model.addAttribute("clientes", Dados.listarClientes());
        return "redirect:/inserir-cliente";
    }
    
       
    @GetMapping("/excluir-cliente")
    public String excluirCliente(Model model, @RequestParam String id) {
        Integer idCliente = Integer.parseInt(id);
        Dados.excluirCliente(idCliente);
        return "redirect:/listagem";
    }
    
    @GetMapping("/alterar-cliente")
    public String AlterarCliente(Model model, @RequestParam String id) {
        Integer idCliente = Integer.parseInt(id);
        model.addAttribute("cliente", Dados.obtemCliente(idCliente));
        return "cadastro";
    }
}