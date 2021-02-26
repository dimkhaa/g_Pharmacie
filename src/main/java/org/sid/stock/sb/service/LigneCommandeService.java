package org.sid.stock.sb.service;

import java.util.List;

import org.sid.stock.sb.dao.LigneCommandeRep;
import org.sid.stock.sb.entities.LigneCommande;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LigneCommandeService{
    @Autowired
	private LigneCommandeRep repository;;

    public List<LigneCommande> findAll(){
        return repository.findAll();
    }
}
