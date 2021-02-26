package org.sid.stock.sb.web;

import java.util.List;
import org.sid.stock.sb.entities.Famille;
import org.sid.stock.sb.service.FamilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javassist.NotFoundException;

@Controller
public class FamilleController {
	@Autowired
	private FamilleService familleService;

	@RequestMapping(value = "/listfamille")
	public String famille(Model model) {

		List<Famille> famille = familleService.findAll();
		model.addAttribute("Listfamille", famille);

		return "familles";
	}

	@RequestMapping(value = "/Supfamille", method = RequestMethod.GET)
	public String delete(Long id) {
		familleService.removeById(id);
		return "redirect:/listfamille";

	}

	@RequestMapping(value = "/ajoutfamille", method = RequestMethod.GET)
	public String ajuterFamille(Model model) {
		model.addAttribute("famille", new Famille());
		return "Ajouterfamille";
	}

	@RequestMapping(value = "/savefamille", method = RequestMethod.POST)
	public String enregistrerMedicament(Model model, Famille famille) {
		familleService.create(famille);
		return "redirect:/listfamille";
	}

	@RequestMapping(value = "/editfamille", method = RequestMethod.GET)
	public String edit(Model model, Long id) {
		Famille famille;
		try {
			famille = familleService.findOne(id);
			
			model.addAttribute("famille", famille);
			model.addAttribute("medicaments", famille.getMedicaments());
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return "Editerfamille";
	  }
	  
	
	 

}
