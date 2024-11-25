
package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.Cliente;
import com.projetoIntegrador.oficinaPolaco.model.ClienteService;
import com.projetoIntegrador.oficinaPolaco.model.Veiculo;
import com.projetoIntegrador.oficinaPolaco.model.VeiculoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/veiculo")
public class veiculoApiController {
    
    @Autowired
    VeiculoService veiculoService;
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("buscar/{id}")
    public ResponseEntity<Veiculo> pesquisar(@PathVariable Integer id){
        Veiculo veiculoEncontrado = veiculoService.buscarId(id);
        return new ResponseEntity<>(veiculoEncontrado, HttpStatus.OK);
    }
       
    @PostMapping("/adicionar/{id}")
    public ResponseEntity<Veiculo> criar(@PathVariable Integer id, @RequestBody Veiculo veiculo){
       Cliente clienteEcontrado = clienteService.buscarId(id);
       Veiculo novoVeiculo = veiculoService.criarVeiculo(veiculo, clienteEcontrado);
       return new ResponseEntity<>(novoVeiculo, HttpStatus.CREATED);
    }
    
    @GetMapping("listar-todos")
    public ResponseEntity<List> listar(){
        List<Veiculo> veiculoLista = veiculoService.listaTodos();
        return new ResponseEntity<>(veiculoLista, HttpStatus.OK);
    }
    /*
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Integer id, @RequestBody Cliente cliente){
        Cliente clienteAtualizado = clienteService.atualizar(id, cliente);
        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
    }*/
    
    @DeleteMapping("excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        veiculoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
