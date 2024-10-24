
package com.projetoIntegrador.oficinaPolaco.model;

import java.util.ArrayList;
import java.util.List;

public class Dados {
    
    private static List<Cliente> listaCliente = new ArrayList();
    

    
    public static void adicionarCliente(Cliente cliente){
        cliente.setId(listaCliente.size() + 1);
        listaCliente.add(cliente);
}

}