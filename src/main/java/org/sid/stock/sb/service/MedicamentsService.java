package org.sid.stock.sb.service;

import java.util.List;

import org.sid.stock.sb.dao.MedicamentsRep;
import org.sid.stock.sb.entities.Medicaments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;


@Service
public class MedicamentsService {
    @Autowired
	private MedicamentsRep repository;;

    public List<Medicaments> findAll(){
        return repository.findAll();
    }

    public Medicaments findOne(Long id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Aucun enregistrement de type Medicaments avec l'id "+id));
    }

    public void removeById(Long id){
        repository.deleteById(id);
    }

    public Medicaments create(Medicaments medicaments){
        return repository.save(medicaments);
    }
}
