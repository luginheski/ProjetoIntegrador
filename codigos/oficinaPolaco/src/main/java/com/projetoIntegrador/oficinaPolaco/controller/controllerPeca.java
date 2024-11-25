
package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.OrcamentoService;
import com.projetoIntegrador.oficinaPolaco.model.OrdemServico;
import com.projetoIntegrador.oficinaPolaco.model.Pecas;
import com.projetoIntegrador.oficinaPolaco.model.PecasService;
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
public class controllerPeca {
    @Autowired
    OrcamentoService osService;
    @Autowired
    PecasService pcService;
    
    @GetMapping("/incluirPeca")
    public String mostraPeca(Model model, @RequestParam String id){
        Integer idOrcamento = Integer.parseInt(id); 
            
        OrdemServico osEncontrada = new OrdemServico();
        osEncontrada = osService.buscarId(idOrcamento);
        //Dados.obtemOs(idOrcamento);
        
        List<Pecas> pecaEncontrada = new ArrayList<>();
        pecaEncontrada = pcService.listarOrdemServicoId(idOrcamento);
        //Dados.listaPeca(idOrcamento);
        model.addAttribute("ordemServico", osEncontrada);
        model.addAttribute("pecas", pecaEncontrada);
        model.addAttribute("peca", new Pecas());
        
        return "pecas";
    }
    
    @PostMapping("/guardarPeca")
    public String processarOs(Model model,@ModelAttribute OrdemServico os, @ModelAttribute Pecas peca, @RequestParam String id){
        pcService.criarPeca(peca, os);
        //Dados.adicionaPeca(peca, os);
        return "redirect:/incluirPeca?id="+id;
    }
    
    @GetMapping("/listarPeca")
    public String mostraPeca(Model model) {
        model.addAttribute("pecas", pcService.listaTodos());
        return "pecas";
    }
    
    @GetMapping("/excluirPeca")
    public String excluirPeca(Model model, @RequestParam String id, @RequestParam String idOs) {
        Integer idPeca = Integer.parseInt(id);
        pcService.excluir(idPeca);
        //Dados.excluirPeca(idPeca);
        return "redirect:/incluirPeca?id="+idOs;
    }
}
