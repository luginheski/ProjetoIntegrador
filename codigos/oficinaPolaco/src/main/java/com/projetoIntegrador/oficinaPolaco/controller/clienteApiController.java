
package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.Cliente;
import com.projetoIntegrador.oficinaPolaco.model.ClienteService;
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
@RequestMapping("/cliente")
public class clienteApiController {
    
    @Autowired
    ClienteService clienteService;
    
    @GetMapping("buscar/{id}")
    public ResponseEntity<Cliente> pesquisar(@PathVariable Integer id){
        Cliente clienteEncontrado = clienteService.buscarId(id);
        return new ResponseEntity<>(clienteEncontrado, HttpStatus.OK);
    }
    
    @PostMapping("/adicionar")
    public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente){
       Cliente novoCliente = clienteService.criarCliente(cliente);
       return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }
    
    @GetMapping("listar-todos")
    public ResponseEntity<List> listar(){
        List<Cliente> filmeCliente = clienteService.listaTodos();
        return new ResponseEntity<>(filmeCliente, HttpStatus.OK);
    }
    
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Integer id, @RequestBody Cliente cliente){
        Cliente clienteAtualizado = clienteService.atualizar(id, cliente);
        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
    }
    
    @DeleteMapping("excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        clienteService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
