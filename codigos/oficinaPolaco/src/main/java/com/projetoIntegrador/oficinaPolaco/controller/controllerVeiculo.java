package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.Cliente;
import com.projetoIntegrador.oficinaPolaco.model.ClienteService;
import com.projetoIntegrador.oficinaPolaco.model.Veiculo;
import com.projetoIntegrador.oficinaPolaco.model.VeiculoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controllerVeiculo {
    @Autowired
    ClienteService clienteService;
    @Autowired
    VeiculoService veiculoService;
       
    @GetMapping("/inserirVeiculo")
    public String mostraVeiculo(Model model, @RequestParam String id){
        Integer idCliente = Integer.parseInt(id);
        Cliente clienteEncontrado = new Cliente();
        clienteEncontrado = clienteService.buscarId(idCliente);
        //clienteEncontrado = Dados.obtemCliente(idCliente);
        
        List<Veiculo> veiculoEncontrado = new ArrayList<>();
        veiculoEncontrado = veiculoService.listarClienteId(idCliente);
        //veiculoEncontrado = Dados.listaVeiculo(idCliente);
        model.addAttribute("cliente", clienteEncontrado);
        model.addAttribute("veiculos", veiculoEncontrado);
        model.addAttribute("veiculo", new Veiculo());
        return "veiculo";
    }
    
    @PostMapping("/guardarVeiculo")
    public String processarVeiculo(Model model, @ModelAttribute Veiculo veiculo, @ModelAttribute Cliente cliente, @RequestParam String id){
        veiculoService.criarVeiculo(veiculo, cliente);
        return "redirect:/inserirVeiculo?id="+id;
    }
    
    @GetMapping("/listarVeiculo")
    public String mostraVeiculo(Model model) {
        model.addAttribute("veiculos", veiculoService.listaTodos());
        return "veiculo";
    }
    
    @GetMapping("/excluirVeiculo")
    public String excluirVeiculo(Model model, @RequestParam String id) {
        Integer idVeiculo = Integer.parseInt(id);
        veiculoService.excluir(idVeiculo);
        //Dados.excluirVeiculo(idVeiculo);
        return "redirect:/inserirCliente";
    }
    
    @PostMapping("/alterarVeiculo")
    public String alteraVeiculo(Model model, @RequestParam String id, @ModelAttribute Veiculo veiculo, @ModelAttribute Cliente cliente){
        Veiculo veiculoEncontrado = new Veiculo();
        Integer idVel = Integer.parseInt(id);
        veiculoEncontrado = veiculoService.buscarId(idVel);
        //veiculoEncontrado = Dados.obtemVeiculo(idVel);
        Cliente idCli = new Cliente();
      
        idCli = clienteService.buscarId(veiculoEncontrado.getCliente().getId());
        //Dados.obtemCliente(veiculoEncontrado.getCliente().getId());
        
        model.addAttribute("veiculo", veiculoService.buscarId(idVel));
        model.addAttribute("cliente", clienteService.buscarId(idCli.getId()));
        return "redirect:/gardarVeiculo";
    }
}