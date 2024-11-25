
package com.projetoIntegrador.oficinaPolaco.controller;

import com.projetoIntegrador.oficinaPolaco.model.Cliente;
import com.projetoIntegrador.oficinaPolaco.model.OrcamentoService;
import com.projetoIntegrador.oficinaPolaco.model.OrdemServico;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordem_servico")
public class orcamentoApiController {
    @Autowired
    VeiculoService veiculoService;
    @Autowired
    OrcamentoService orcamentoService;
    
     @GetMapping("buscar/{id}")
    public ResponseEntity<OrdemServico> pesquisar(@PathVariable Integer id){
        OrdemServico osEncontrado = orcamentoService.buscarId(id);
        return new ResponseEntity<>(osEncontrado, HttpStatus.OK);
    }
       
    @PostMapping("/adicionar/{id}")
    public ResponseEntity<OrdemServico> criar(@PathVariable Integer id, @RequestBody OrdemServico os){
       Veiculo veiculoEcontrado = veiculoService.buscarId(id);
       OrdemServico novoOs = orcamentoService.criarOs(veiculoEcontrado, os);
       return new ResponseEntity<>(novoOs, HttpStatus.CREATED);
    }
    
    @GetMapping("listar-todos")
    public ResponseEntity<List> listar(){
        List<OrdemServico> osLista = orcamentoService.listaTodos();
        return new ResponseEntity<>(osLista, HttpStatus.OK);
    }
    /*
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Integer id, @RequestBody Cliente cliente){
        Cliente clienteAtualizado = clienteService.atualizar(id, cliente);
        return new ResponseEntity<>(clienteAtualizado, HttpStatus.OK);
    }*/
    
    @DeleteMapping("excluir/{id}")
    public ResponseEntity<?> deletar(@PathVariable Integer id){
        orcamentoService.excluir(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
