
package com.projetoIntegrador.oficinaPolaco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Pecas {
    
    private Integer idPeca;
    private String descricao;
    private double valorUnt;
    private double quantidade;
    private double valorTotal;
    private int porcento;
    private OrdemServico ordemServicoId;
    
}
