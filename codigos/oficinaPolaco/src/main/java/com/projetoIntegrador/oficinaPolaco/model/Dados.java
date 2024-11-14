package com.projetoIntegrador.oficinaPolaco.model;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    private static List<Cliente> listaCliente = new ArrayList();
    private static List<Veiculo> listaVeiculo = new ArrayList();

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
            if (v.getIdCliente().getId() == idCliente) {
                veiculoEncontrado.add(v);
            }
        }
        return veiculoEncontrado;
    }
    
    public static void adicionaVeiculo(Veiculo veiculo, Cliente cliente){
        veiculo.setIdVeiculo(listaVeiculo.size()+1);
        veiculo.setIdCliente(cliente);
        listaVeiculo.add(veiculo);
    }
    
    public static Veiculo obtemVeiculo(Integer id){
        Veiculo veiculoEncontrado = new Veiculo();
        for (Veiculo v : listaVeiculo){
            if (v.getIdVeiculo() == id){
                veiculoEncontrado = v;
            }
        }
        return veiculoEncontrado;
    }
    
    public static void excluirVeiculo(Integer id){
        for(Veiculo v : listaVeiculo){
            if(v.getIdVeiculo() == id);
            listaVeiculo.remove(v);
            break;
        }
    }
}