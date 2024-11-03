package com.projetoIntegrador.oficinaPolaco.model;

import java.util.ArrayList;
import java.util.List;

public class Dados {

    private static List<Cliente> listaCliente = new ArrayList();

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

    public static Cliente obtemCliente(String cpf) {
        Cliente clienteEncontrado = new Cliente();
        for (Cliente c : listaCliente) {
            if (c.getCpf() == cpf) {
                clienteEncontrado = c;
                   clienteEncontrado.setNome(c.getNome());
                   clienteEncontrado.setRg(c.getRg());
                   clienteEncontrado.setCpf(c.getCpf());
                   clienteEncontrado.setRua(c.getRua());
                   clienteEncontrado.setNumero(c.getNumero());
                   clienteEncontrado.setBairro(c.getBairro());
                   clienteEncontrado.setCidade(c.getCidade());
                   clienteEncontrado.setEstado(c.getEstado());
                break;
            }
        }
        return clienteEncontrado;
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
    
    public static Cliente obtemClientes(String cpf) {
        Cliente clienteEncontrado = new Cliente();
        for (Cliente c : listaCliente) {
            if (c.getCpf() == cpf) {
                clienteEncontrado = c;
                break;
            }
        }
        return clienteEncontrado;
    }
}
