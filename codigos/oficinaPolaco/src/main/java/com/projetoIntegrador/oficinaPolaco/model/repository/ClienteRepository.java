
package com.projetoIntegrador.oficinaPolaco.model.repository;

import com.projetoIntegrador.oficinaPolaco.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
    
}