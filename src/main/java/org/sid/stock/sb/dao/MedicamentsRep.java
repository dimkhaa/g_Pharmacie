package org.sid.stock.sb.dao;

import org.sid.stock.sb.entities.Medicaments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicamentsRep extends JpaRepository<Medicaments, Long> {
	@Query("update Medicaments m set m.quantite = :x where m.idMedicament = :y")
	public void updateQuantite(@Param("x")int q, @Param("y") Long y);
}
