
package com.projetoIntegrador.oficinaPolaco.model;

import com.projetoIntegrador.oficinaPolaco.model.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;
    
public Cliente buscarId(Integer id){
        return clienteRepository.findById(id).orElseThrow();
    }
    
    public Cliente criarCliente(Cliente cliente){
        cliente.setId(null);
        clienteRepository.save(cliente);
        return cliente;
    }
    
    public List<Cliente> listaTodos(){
        return clienteRepository.findAll();
    }
    
    public Cliente atualizar(Integer id, Cliente cliente){
        Cliente clienteEncontrado = buscarId(id);
        clienteEncontrado.setNome(cliente.getNome());
        clienteEncontrado.setCpf(cliente.getCpf());
        clienteEncontrado.setRg(cliente.getRg());
        clienteEncontrado.setRua(cliente.getRua());
        clienteEncontrado.setNumero(cliente.getNumero());
        clienteEncontrado.setTelefone(cliente.getTelefone());
        clienteEncontrado.setCidade(cliente.getCidade());
        clienteEncontrado.setBairro(cliente.getBairro());
        clienteEncontrado.setCep(cliente.getCep());
        clienteEncontrado.setEstado(cliente.getEstado());
        clienteRepository.save(clienteEncontrado);
        return clienteEncontrado;
    }
    
    public void excluir(Integer id){
        Cliente clienteEncontrado = buscarId(id);
        clienteRepository.deleteById(clienteEncontrado.getId());
    }
}
