package org.sid.stock.sb.web;

import java.util.List;

import org.sid.stock.sb.entities.Commande;
import org.sid.stock.sb.entities.LigneCommande;
import org.sid.stock.sb.service.CommandeService;
import org.sid.stock.sb.service.FamilleService;
import org.sid.stock.sb.service.FournisseurService;
import org.sid.stock.sb.service.LigneCommandeService;
import org.sid.stock.sb.service.MedicamentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javassist.NotFoundException;

@Controller
public class CommandeController {

	@Autowired
	private CommandeService service;
	@Autowired
	private LigneCommandeService ligneCommandeService;
	@Autowired
	private FamilleService familleService;
	@Autowired
	private MedicamentsService medicamentsService;

	@Autowired
	private FournisseurService fournisseurService;

	@RequestMapping(value = "/lignecommande")
	public String ligneCommande(Model model) {
		List<LigneCommande> lignecommande = ligneCommandeService.findAll();
		model.addAttribute("listCommande", lignecommande);
		return "ligne de commande";
	}

	@RequestMapping(value = "/commande", method = RequestMethod.GET)
	public String index(Model model) {
		/*
		 * Commande c = new Commande(); int quantite =
		 * c.getLignecommandes().getQuantitemedoc();
		 */
		List<Commande> commande = service.allCommandes();
		// List<LigneCommande> ligneCommandes= ligneCommandeRep.findAll();
		model.addAttribute("listCommande", commande);
		// model.addAttribute( "listLigneCommande", new LigneCommande());
		return "Commandes";
	}

	@RequestMapping(value = "/nouveaucommande", method = RequestMethod.GET)
	public String ajuterCommande(Model model) {
		model.addAttribute("commande", new Commande());
		model.addAttribute("lignecommande", new LigneCommande());
		model.addAttribute("famille", familleService.findAll());
		model.addAttribute("medicament", medicamentsService.findAll());
		model.addAttribute("listCommande", ligneCommandeService.findAll());
		model.addAttribute("fournisseur", fournisseurService.findAll());
		return "nouvelleCommande";
	}

	@RequestMapping(value = "/enregistrercommande", method = RequestMethod.POST)
	public String enregistrerMedicament(Model model, Commande commande, LigneCommande ligneCommande, Long idFour,Long idMed) {
		try {
			service.ajoutCommande(commande, ligneCommande, idFour, idMed);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/commande";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(Model model){
		List<LigneCommande> lignecommande = ligneCommandeService.findAll();
		model.addAttribute("listCommande", lignecommande);
		return "details";
	}
	
	@RequestMapping(value="/retour",method=RequestMethod.GET)
	public String retour(Model model){
		return "redirect:/commande";
	}

}

