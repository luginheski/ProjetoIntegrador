package com.projetoIntegrador.oficinaPolaco.model;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    private static List<Cliente> listaCliente = new ArrayList();
    private static List<Veiculo> listaVeiculo = new ArrayList();
    private static List<OrdemServico> listaOs = new ArrayList();
    private static List<Pecas> listaPeca = new ArrayList();

    public static void adicionarCliente(Cliente cliente) {
        cliente.setId(listaCliente.size() + 1);
        listaCliente.add(cliente);
    }

    public static List<Cliente> listarClientes() {
        return listaCliente;
    }
    
    public static void excluirCliente(Integer id) {
        for (Cliente c : listaCliente) {
            if (c.getId() == id) {
                listaCliente.remove(c);
                break;
            }
        }
    }
   
    public static void atualizarCliente(Cliente cliente) {
        for (Cliente c : listaCliente) {
            if (c.getId() == cliente.getId()) {
                c.setNome(cliente.getNome());
                c.setRg(cliente.getRg());
                c.setCpf(cliente.getCpf());
                c.setRua(cliente.getRua());
                c.setNumero(cliente.getNumero());
                c.setBairro(cliente.getBairro());
                c.setCidade(cliente.getCidade());
                c.setEstado(cliente.getEstado());
                break;
            }
        }
    }
    
    public static Cliente obtemCliente(Integer id) {
        Cliente clienteEncontrado = new Cliente();
        for (Cliente c : listaCliente) {
            if (c.getId() == id) {
                clienteEncontrado = c;
                break;
            }
        }
        return clienteEncontrado;
    }
    
    
    public static List<Veiculo> listarVeiculos() {
        return listaVeiculo;
    }
    
    public static List<Veiculo> listaVeiculo(Integer idCliente) {
        List<Veiculo> veiculoEncontrado = new ArrayList<>();
        for (Veiculo v : listaVeiculo) {
            if (v.getCliente().getId() == idCliente) {
                veiculoEncontrado.add(v);
            }
        }
        return veiculoEncontrado;
    }
    
    public static void adicionaVeiculo(Veiculo veiculo, Cliente cliente){
        veiculo.setId(listaVeiculo.size()+1);
        veiculo.setCliente(cliente);
        listaVeiculo.add(veiculo);
    }
    
    public static Veiculo obtemVeiculo(Integer id){
        Veiculo veiculoEncontrado = new Veiculo();
        for (Veiculo v : listaVeiculo){
            if (v.getId() == id){
                veiculoEncontrado = v;
            }
        }
        return veiculoEncontrado;
    }
    
    public static void excluirVeiculo(Integer id){
        for (Veiculo v : listaVeiculo){
            if(v.getId() == id){
            listaVeiculo.remove(v);
            break;
            }
        }
    }
    
    public static List<Veiculo> listarOss() {
        return listaVeiculo;
    }
    
    public static List<OrdemServico> listaOs(Integer idVeiculo) {
        List<OrdemServico> osEncontrada = new ArrayList<>();
        for (OrdemServico o : listaOs) {
            if (o.getVeiculo().getId() == idVeiculo) {
                osEncontrada.add(o);
            }
        }
        return osEncontrada;
    }
    
    public static void adicionaOs(OrdemServico os, Veiculo veiculo){
        os.setId(listaOs.size()+1);
        os.setVeiculo(veiculo);
        listaOs.add(os);
    }
    
    public static OrdemServico obtemOs(Integer id){
        OrdemServico osEncontrado = new OrdemServico();
        for (OrdemServico o : listaOs){
            if (o.getId() == id){
                osEncontrado = o;
            }
        }
        return osEncontrado;
    }
    
    public static void excluirOs(Integer id){
        for (OrdemServico o : listaOs){
            if(o.getId() == id){
            listaOs.remove(o);
            break;
            }
        }
    }
    
    public static List<Pecas> listarpecas() {
        return listaPeca;
    }
    
    public static List<Pecas> listaPeca(Integer idOrcamento) {
        List<Pecas> pecaEncontrada = new ArrayList<>();
        for (Pecas p : listaPeca) {
            if (p.getOrdemServico().getId() == idOrcamento) {
                pecaEncontrada.add(p);
            }
        }
        return pecaEncontrada;
    }
        
    public static void adicionaPeca(Pecas peca, OrdemServico os){
        double qnt = peca.getQuantidade();
        double vlUnt = peca.getValorUnt();
        int porc = peca.getPorcento();
        double total;
        
        total = (((vlUnt*porc)/100)+vlUnt)*qnt;
        
        peca.setId(listaPeca.size()+1);
        peca.setOrdemServico(os);
        peca.setValorTotal(total);
        
        listaPeca.add(peca);
    }
    
    public static Pecas obtemPeca(Integer id){
        Pecas pecaEncontrada = new Pecas();
        for(Pecas p : listaPeca){
            if(p.getId() == id){
                pecaEncontrada = p;
            }
        }
        return pecaEncontrada;
    }
    
    public static void excluirPeca(Integer id){
        for (Pecas p : listaPeca){
            if(p.getId() == id){
                listaPeca.remove(p);
                break;
            }
        }
    }
}
