package org.sid.stock.sb.dao;

import org.sid.stock.sb.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRep  extends JpaRepository<Stock, Long>{

}
