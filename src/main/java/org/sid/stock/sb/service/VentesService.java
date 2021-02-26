package org.sid.stock.sb.service;

import java.util.List;

import org.sid.stock.sb.dao.VentesRep;
import org.sid.stock.sb.entities.Ventes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentesService{
    @Autowired
    private VentesRep repository;

    public List<Ventes> findAll(){
        return repository.findAll();
    }

    public Ventes create(Ventes vente){
        return repository.save(vente);
    }
}
