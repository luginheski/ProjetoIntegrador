
package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.Dados;
import com.projetoIntegrador.oficinaPolaco.model.OrdemServico;
import com.projetoIntegrador.oficinaPolaco.model.Pecas;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class controllerPeca {
    @GetMapping("/incluirPeca")
    public String mostraPeca(Model model, @RequestParam String id){
        Integer idOrcamento = Integer.parseInt(id); 
            
        OrdemServico osEncontrada = new OrdemServico();
        osEncontrada = Dados.obtemOs(idOrcamento);
        
        List<Pecas> pecaEncontrada = new ArrayList<>();
        pecaEncontrada = Dados.listaPeca(idOrcamento);
        model.addAttribute("ordemServico", osEncontrada);
        model.addAttribute("pecas", pecaEncontrada);
        model.addAttribute("peca", new Pecas());
        
        return "pecas";
    }
    
    @PostMapping("/guardarPeca")
    public String processarOs(Model model,@ModelAttribute OrdemServico os, @ModelAttribute Pecas peca, @RequestParam String id){
        Dados.adicionaPeca(peca, os);
        return "redirect:/incluirPeca?id="+id;
    }
      
    @GetMapping("/listarPeca")
    public String mostraPeca(Model model) {
        model.addAttribute("pecas", Dados.listarpecas());
        return "pecas";
    }
    
    @GetMapping("/excluirPeca")
    public String excluirPeca(Model model, @RequestParam String id, @RequestParam String idOs) {
        Integer idPeca = Integer.parseInt(id);

        Dados.excluirPeca(idPeca);
        return "redirect:/incluirPeca?id="+idOs;
    }
}
