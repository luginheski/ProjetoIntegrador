
package com.projetoIntegrador.oficinaPolaco.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Veiculo {
    
    private Integer idVeiculo;
    private String fabricante;
    private String modelo;
    private int anoFabricacao;
    private int anoModelo;
    private Integer hodometro;
    private String placa;
    private Cliente idCliente;
}
