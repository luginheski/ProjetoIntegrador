
package com.projetoIntegrador.oficinaPolaco.model.repository;

import com.projetoIntegrador.oficinaPolaco.model.OrdemServico;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrcamentoRepository extends JpaRepository<OrdemServico, Integer>{
    List<OrdemServico> findByVeiculoId(Integer id);
}
