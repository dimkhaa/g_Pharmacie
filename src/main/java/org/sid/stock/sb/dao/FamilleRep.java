package org.sid.stock.sb.dao;

import org.sid.stock.sb.entities.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilleRep extends JpaRepository<Famille, Long>{
	
	public Famille findByCode(String fam);

}
