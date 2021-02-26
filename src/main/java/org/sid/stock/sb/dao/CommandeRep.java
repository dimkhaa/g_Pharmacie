package org.sid.stock.sb.dao;

import org.sid.stock.sb.entities.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRep extends JpaRepository<Commande, Long>{

}
