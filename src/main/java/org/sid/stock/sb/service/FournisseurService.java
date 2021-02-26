package org.sid.stock.sb.service;

import java.util.List;

import org.sid.stock.sb.dao.FournisseurRep;
import org.sid.stock.sb.entities.Fournisseur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FournisseurService{
    @Autowired
	private FournisseurRep repository;;

    public List<Fournisseur> findAll(){
        return repository.findAll();
    }

    
    public Fournisseur findOne(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Aucun enregistrement de type Fournisseur avec l'id "+id));
    }

    public void removeById(Long id){
        repository.deleteById(id);
    }

    public Fournisseur create(Fournisseur fournisseur){
        return repository.save(fournisseur);
    }
}
