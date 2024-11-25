
package com.projetoIntegrador.oficinaPolaco.model.repository;

import com.projetoIntegrador.oficinaPolaco.model.Pecas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PecasRepository extends JpaRepository<Pecas, Integer>{
    List<Pecas> findByOrdemServicoId(Integer id);
}
