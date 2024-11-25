
package com.projetoIntegrador.oficinaPolaco.model;

import com.projetoIntegrador.oficinaPolaco.model.repository.VeiculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 @Service
public class VeiculoService {
      @Autowired
      VeiculoRepository veiculoRepository;
      
      public Veiculo buscarId(Integer id){
        return veiculoRepository.findById(id).orElseThrow();
    }
    
    public Veiculo criarVeiculo(Veiculo veiculo, Cliente cliente){
        veiculo.setId(null);
        veiculo.setCliente(cliente);
        veiculoRepository.save(veiculo);
        return veiculo;
    }
    
    public List<Veiculo> listaTodos(){
        return veiculoRepository.findAll();
    }
    
    public void excluir(Integer id){
        Veiculo veiculoEncontrado = buscarId(id);
        veiculoRepository.deleteById(veiculoEncontrado.getId());
    }
    
    public List<Veiculo> listarClienteId(Integer id){
        return veiculoRepository.findByClienteId(id);
    }

}
