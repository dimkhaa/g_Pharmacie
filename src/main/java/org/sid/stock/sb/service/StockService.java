package org.sid.stock.sb.service;

import java.util.List;

import org.sid.stock.sb.dao.StockRep;
import org.sid.stock.sb.entities.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService{
    @Autowired
    private StockRep repository;

    public List<Stock> findAll(){
        return repository.findAll();
    }
}
