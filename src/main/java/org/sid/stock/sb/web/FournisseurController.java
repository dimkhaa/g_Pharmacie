package org.sid.stock.sb.web;

import java.util.List;
import org.sid.stock.sb.entities.Fournisseur;
import org.sid.stock.sb.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javassist.NotFoundException;

@Controller
public class FournisseurController {

	@Autowired
	private FournisseurService fournisseurService;

	@RequestMapping(value = "/indexfourni")
	public String fournisseur(Model model) {
		List<Fournisseur> fournisseur = fournisseurService.findAll();
		model.addAttribute("listFournisseur", fournisseur);
		return "Fournisseurs";

	}

	@RequestMapping(value = "/nouveaufourni", method = RequestMethod.GET)
	public String ajuterFounisseur(Model model) {
		model.addAttribute("fournisseur", new Fournisseur());
		return "formFournisseur";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String enregistrerFournisseur(Model model, Fournisseur fournisseur) {
		fournisseurService.create(fournisseur);
		return "redirect:/indexfourni";
	}

	@RequestMapping(value = "/SuprimeF", method = RequestMethod.GET)
	public String delete(Long id) {
		fournisseurService.removeById(id);
		return "redirect:/indexfourni";

	}

	@RequestMapping(value = "/editF", method = RequestMethod.GET)
	public String edit(Model model, Long id) {
		Fournisseur fournisseur ;
		try {
			fournisseur = fournisseurService.findOne(id);
			
			model.addAttribute("fournisseur", fournisseur);
			model.addAttribute("commande", fournisseur.getCommande());
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "EditFournisseur";
	}
}

