package com.projetoIntegrador.oficinaPolaco.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrdemServico {
        
    private Integer idOs;
    private Integer hodometroAntigo;
    private Integer hodometroAtual;    
    private Date dataServico;
    private Veiculo velId;

}
