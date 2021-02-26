package org.sid.stock.sb.service;

import java.util.List;

import org.sid.stock.sb.dao.PharmacienRep;
import org.sid.stock.sb.entities.Pharmacien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class PharmacienService{
    
    @Autowired
	private PharmacienRep repository;;

    public List<Pharmacien> findAll(){
        return repository.findAll();
    }

    public Pharmacien findOne(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Aucun enregistrement de type Pharmacien avec l'id "+id));
    }

    public void removeById(Long id){
        repository.deleteById(id);
    }

    public Pharmacien create(Pharmacien pharmacien){
        return repository.save(pharmacien);
    }
}
