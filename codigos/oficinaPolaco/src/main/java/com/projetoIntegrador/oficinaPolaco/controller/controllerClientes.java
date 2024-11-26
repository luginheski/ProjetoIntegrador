package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.Cliente;
import com.projetoIntegrador.oficinaPolaco.model.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controllerClientes {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("/")
    public String index(){
        return "redirect:/inserirCliente";
    }
        
    @GetMapping("/inserirCliente")
    public String mostraCadastro(Model model) {
            model.addAttribute("cliente", new Cliente());
            model.addAttribute("clientes", clienteService.listaTodos());
        return "index";
    }
  
    @PostMapping("/cadastroCliente")
    public String processarCliente(Model model, @ModelAttribute Cliente cliente) {
        if (cliente.getId() != null){
            clienteService.atualizar(cliente.getId(), cliente);
            //Dados.atualizarCliente(cliente);
        } else {
            clienteService.criarCliente(cliente);
            //Dados.adicionarCliente(cliente);
        }
        return "redirect:/inserirCliente";
    }   
    
     @GetMapping("/listar")
    public String mostraCliente(Model model) {
        model.addAttribute("clientes", clienteService.listaTodos());
        return "cadastroCliente";
    }
           
    @GetMapping("/excluir-cliente")
    public String excluirCliente(Model model, @RequestParam String id) {
        Integer idCliente = Integer.parseInt(id);
        clienteService.excluir(idCliente);
        //Dados.excluirCliente(idCliente);
        return "redirect:/inserirCliente";
    }
    
    @GetMapping("/alterar-cliente")
    public String AlterarCliente(Model model, @RequestParam String id, @ModelAttribute Cliente cliente) {
        Integer idCliente = Integer.valueOf(id);
        model.addAttribute("cliente", clienteService.buscarId(idCliente));
        return "index";
    }
}