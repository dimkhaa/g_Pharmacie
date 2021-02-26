package org.sid.stock.sb.service;

import java.util.List;

import org.sid.stock.sb.dao.VenteMedicamentRep;
import org.sid.stock.sb.entities.VenteMedicament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;

@Service
public class VenteMedicamentService{
    @Autowired
    private VenteMedicamentRep repository;

    public List<VenteMedicament> findAll(){
        return repository.findAll();
    }

    public VenteMedicament create(VenteMedicament vente){
        return repository.save(vente);
    }

    public VenteMedicament findOne(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Aucun enregistrement de type VenteMedicament avec l'id "+id));
    }
}
