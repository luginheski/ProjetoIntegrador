
package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.OrcamentoService;
import com.projetoIntegrador.oficinaPolaco.model.OrdemServico;
import com.projetoIntegrador.oficinaPolaco.model.Pecas;
import com.projetoIntegrador.oficinaPolaco.model.PecasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pecas")
public class pecaApiController {
    @Autowired
    PecasService pecasService;
    @Autowired
    OrcamentoService orcamentoService;
    
    @GetMapping("buscar/{id}")
    public ResponseEntity<Pecas>pesquisar(@PathVariable Integer id){
        Pecas pcEncontrado = pecasService.buscarId(id);
        return new ResponseEntity<>(pcEncontrado, HttpStatus.OK);
    }
       
    @PostMapping("/adicionar/{id}")
    public ResponseEntity<Pecas> criar(@PathVariable Integer id, @RequestBody Pecas pc){
       OrdemServico osEcontrado = orcamentoService.buscarId(id);
       Pecas novoPc = pecasService.criarPeca(pc, osEcontrado);
       return new ResponseEntity<>(novoPc, HttpStatus.CREATED);
    }
    
    @GetMapping("listar-todos")
    public ResponseEntity<List> listar(){
        List<Pecas> pcLista = pecasService.listaTodos();
        return new ResponseEntity<>(pcLista, HttpStatus.OK);
    }
    /*
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Integer id, @RequestBody Cliente cliente){
        Cliente clienteAtualizado = clienteService.atualizar(id, cliente);
        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
    }*/
    
    @DeleteMapping("excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        pecasService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
