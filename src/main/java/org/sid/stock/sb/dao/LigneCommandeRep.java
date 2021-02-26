package org.sid.stock.sb.dao;

import org.sid.stock.sb.entities.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRep extends JpaRepository<LigneCommande, Long> {

}
