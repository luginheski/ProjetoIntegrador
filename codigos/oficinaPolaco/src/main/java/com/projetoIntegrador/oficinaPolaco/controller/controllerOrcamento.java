
package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.OrcamentoService;
import com.projetoIntegrador.oficinaPolaco.model.OrdemServico;
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
public class controllerOrcamento {
    @Autowired
    VeiculoService veiculoService;
    @Autowired
    OrcamentoService osService;
    
    @GetMapping("/incluirOrcamento")
    public String mostraOS(Model model, @RequestParam String id){
        Integer idVeiculo = Integer.parseInt(id);
        
        Veiculo veiculoEncontrado = new Veiculo();
        veiculoEncontrado = veiculoService.buscarId(idVeiculo);
        //Dados.obtemVeiculo(idVeiculo);
        
        List<OrdemServico> osEncontrada = new ArrayList<>();
        osEncontrada = osService.listarVeiculoId(idVeiculo);
        //Dados.listaOs(idVeiculo);        
        model.addAttribute("veiculo", veiculoEncontrado);
        model.addAttribute("ordemServicos", osEncontrada);
        model.addAttribute("ordemServico", new OrdemServico());
        
        return "orcamentos";
    }
    
    @PostMapping("/guardarOs")
    public String processarOs(Model model, @ModelAttribute Veiculo veiculo, @ModelAttribute OrdemServico os, @RequestParam String id){
        osService.criarOs(veiculo, os);
        //Dados.adicionaOs(os, veiculo);
        return "redirect:/incluirOrcamento?id="+id;
    }
      
    @GetMapping("/listarOs")
    public String mostraVeiculo(Model model) {
        model.addAttribute("ordemServicos", osService.listaTodos());
        return "orcamentos";
    }
    
    @GetMapping("/excluirOs")
    public String excluirOs(Model model, @RequestParam String id) {
        Integer idOs = Integer.parseInt(id);
        osService.excluir(idOs);
        //Dados.excluirOs(idOs);
        return "redirect:/inserirCliente";
    }
}