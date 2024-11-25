
package com.projetoIntegrador.oficinaPolaco.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="cliente")

public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
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
}
