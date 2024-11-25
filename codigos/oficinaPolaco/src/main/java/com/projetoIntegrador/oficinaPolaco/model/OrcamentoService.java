
package com.projetoIntegrador.oficinaPolaco.model;

import com.projetoIntegrador.oficinaPolaco.model.repository.OrcamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
public class OrcamentoService {
    @Autowired
    OrcamentoRepository orcamentoRepository;
    
     public OrdemServico buscarId(Integer id){
        return orcamentoRepository.findById(id).orElseThrow();
    }
   
     public OrdemServico criarOs(Veiculo veiculo, OrdemServico os){
        os.setId(null);
        os.setVeiculo(veiculo);
        orcamentoRepository.save(os);
        return os;
    }
    
    public List<OrdemServico> listaTodos(){
        return orcamentoRepository.findAll();
    }
    
    public void excluir(Integer id){
        OrdemServico osEncontrado = buscarId(id);
        orcamentoRepository.deleteById(osEncontrado.getId());
    }
    
    public List<OrdemServico> listarVeiculoId(Integer id){
        return orcamentoRepository.findByVeiculoId(id);
    }
}
