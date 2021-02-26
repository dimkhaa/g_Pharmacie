package org.sid.stock.sb.service;

import java.util.List;

import org.sid.stock.sb.dao.FamilleRep;
import org.sid.stock.sb.entities.Famille;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class FamilleService{

	@Autowired
	private FamilleRep repository;;

    public List<Famille> findAll(){
        return repository.findAll();
    }

    public Famille findOne(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Aucun enregistrement de type Famille avec l'id "+id));
    }

    public void removeById(Long id){
        repository.deleteById(id);
    }

    public Famille create(Famille famille){
        return repository.save(famille);
    }

}
