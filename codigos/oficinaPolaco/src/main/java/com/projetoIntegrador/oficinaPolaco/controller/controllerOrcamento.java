
package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.Dados;
import com.projetoIntegrador.oficinaPolaco.model.OrdemServico;
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
public class controllerOrcamento {
    
    @GetMapping("/incluirOrcamento")
    public String mostraOS(Model model, @RequestParam String id){
        Integer idVeiculo = Integer.parseInt(id);
        
        Veiculo veiculoEncontrado = new Veiculo();
        veiculoEncontrado = Dados.obtemVeiculo(idVeiculo);
        
        List<OrdemServico> osEncontrada = new ArrayList<>();
        osEncontrada = Dados.listaOs(idVeiculo);        
        model.addAttribute("veiculo", veiculoEncontrado);
        model.addAttribute("ordemServicos", osEncontrada);
        model.addAttribute("ordemServico", new OrdemServico());
        
        return "orcamentos";
    }
    
    @PostMapping("/guardarOs")
    public String processarOs(Model model, @ModelAttribute Veiculo veiculo, @ModelAttribute OrdemServico os, @RequestParam String id){
        Dados.adicionaOs(os, veiculo);
        return "redirect:/incluirOrcamento?id="+id;
    }
      
    @GetMapping("/listarOs")
    public String mostraVeiculo(Model model) {
        model.addAttribute("ordemServicos", Dados.listarOss());
        return "orcamentos";
    }
    
    @GetMapping("/excluirOs")
    public String excluirOs(Model model, @RequestParam String id) {
        Integer idOs = Integer.parseInt(id);
        Dados.excluirOs(idOs);
        return "redirect:/inserirCliente";
    }
}