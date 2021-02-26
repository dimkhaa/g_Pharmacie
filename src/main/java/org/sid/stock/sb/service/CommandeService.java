package org.sid.stock.sb.service;

import java.util.ArrayList;
import java.util.List;

import org.sid.stock.sb.dao.CommandeRep;
import org.sid.stock.sb.dao.FournisseurRep;
import org.sid.stock.sb.dao.LigneCommandeRep;
import org.sid.stock.sb.dao.MedicamentsRep;
import org.sid.stock.sb.entities.Commande;
import org.sid.stock.sb.entities.Fournisseur;
import org.sid.stock.sb.entities.LigneCommande;
import org.sid.stock.sb.entities.Medicaments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javassist.NotFoundException;


@Service
public class CommandeService {
    @Autowired
	private CommandeRep repository;
    @Autowired
	private FournisseurRep fournisseurRep;
	@Autowired
	private MedicamentsRep medicamentsRep;
    @Autowired
	private LigneCommandeRep ligneCommandeRep;

    public Commande ajoutCommande(Commande commande, LigneCommande ligneCommande, Long four, Long med)
			throws NotFoundException {
        Fournisseur f = fournisseurRep.findById(med).orElseThrow(() -> new NotFoundException("Aucun enregistrement de type Fournisseur avec l'id "+four));

		Medicaments m = medicamentsRep.findById(med).orElseThrow(() -> new NotFoundException("Aucun enregistrement de type Medicament avec l'id "+med));


		commande.setFournisseur(f);	
		ligneCommande.setMedicaments(m);
	//	ligneCommande.setPrix_unitaire(m.getPrixAchat());
		ligneCommande.setCommande(commande);
		List<LigneCommande> lc = new ArrayList();
		lc.add(ligneCommande);
		commande.setLignecommandes(lc);
		repository.save(commande);
		ligneCommandeRep.save(ligneCommande);
		return commande;
    }

    public List<Commande> allCommandes(){
        return repository.findAll();
    }
}
