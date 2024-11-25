
package com.projetoIntegrador.oficinaPolaco.model;

import com.projetoIntegrador.oficinaPolaco.model.repository.PecasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
public class PecasService {
    @Autowired
    PecasRepository pecasRepository;   
    
     public Pecas buscarId(Integer id){
        return pecasRepository.findById(id).orElseThrow();
    }
    
    public Pecas criarPeca(Pecas peca, OrdemServico os){
        double qnt = peca.getQuantidade();
        double vlUnt = peca.getValorUnt();
        int porc = peca.getPorcento();
        double total;
        total = (((vlUnt*porc)/100)+vlUnt)*qnt;
        peca.setId(null);
        peca.setValorTotal(total);
        peca.setOrdemServico(os);
        pecasRepository.save(peca);
        return peca;
    }
    
    public List<Pecas> listaTodos(){
        return pecasRepository.findAll();
    }
    
    public void excluir(Integer id){
        Pecas pecaEncontrado = buscarId(id);
        pecasRepository.deleteById(pecaEncontrado.getId());
    }
    
     public List<Pecas> listarOrdemServicoId(Integer id){
        return pecasRepository.findByOrdemServicoId(id);
    }
}
