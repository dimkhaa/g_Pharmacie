package org.sid.stock.sb.web;

import java.util.Date;
import java.util.List;


import org.sid.stock.sb.dao.MedicamentsRep;
import org.sid.stock.sb.entities.Ventes;
import org.sid.stock.sb.service.VenteMedicamentService;
import org.sid.stock.sb.service.VentesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javassist.NotFoundException;

@Controller
public class VenteController {

	@Autowired
	private VentesService ventesService;
	@Autowired
	private MedicamentsRep medicamentsRep;

	@Autowired
	VenteMedicamentService venteMedicamentService;

	@GetMapping(value = "/vente")
	public String index(Model model) {
		List<Ventes> ventes = ventesService.findAll();
		model.addAttribute("ListVente", ventes);
		model.addAttribute("med", medicamentsRep.findAll());
		return "Ventes";
	}

	@RequestMapping(value = "/ajoutvente", method = RequestMethod.GET)
	public String ajoutvente(Model model, Long medic) {
		model.addAttribute("vente", new Ventes());
		try {
			model.addAttribute("m", venteMedicamentService.findOne(medic));
			model.addAttribute("venteMedicament", venteMedicamentService.findAll());
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
			return "Ajoutvente";
	}
		
		@GetMapping(value="/savevente")
		public String enregistrerVente(Model model , float montant, Long id, int quantite){
			ventesService.create(new Ventes(new Date(), montant));
			medicamentsRep.updateQuantite(quantite, id);
			return "redirect:/vente";
		}
}
