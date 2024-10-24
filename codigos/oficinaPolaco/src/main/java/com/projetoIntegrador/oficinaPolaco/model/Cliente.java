
package com.projetoIntegrador.oficinaPolaco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Cliente {
    private Integer id;
    private String nome;
    private String rg;
    private String cpf;
    private String telefone;
    private String rua;
    private int numero;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private Veiculo placa;
}
