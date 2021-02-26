package org.sid.stock.sb.web;

import java.util.List;

import org.sid.stock.sb.entities.Famille;
import org.sid.stock.sb.entities.Medicaments;
import org.sid.stock.sb.service.FamilleService;
import org.sid.stock.sb.service.MedicamentsService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javassist.NotFoundException;

@Controller
public class MedicamentController {
	@Autowired
	private MedicamentsService medicamentsService;

	@Autowired
	private FamilleService familleService;

	// @Secured(value={"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value = "/blank", method = RequestMethod.GET)
	public String blankPage() {
		return "blank";
	}

	// @Secured(value={"ROLE_ADMIN", "ROLE_USER"})
	@RequestMapping(value = "/index")
	public String index(Model model) {
		List<Medicaments> medicaments = medicamentsService.findAll();
		List<Famille> famille = familleService.findAll();
		model.addAttribute("listMedicaments", medicaments);
		model.addAttribute("Listfamille", famille);
		return "medicaments";
	}

	// @Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/Supprimer", method = RequestMethod.GET)
	public String delete(Long id) {
		medicamentsService.removeById(id);
		return "redirect:/users/index";

	}

	// @Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajuterMedicament(Model model) {
		model.addAttribute("medicament", new Medicaments());
		model.addAttribute("famille", familleService.findAll());
		return "formulaireMedicament";

	}

	// @Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String enregistrerMedicament(Model model, Medicaments medicament, Long fam) {
		try {
			medicament.setFamille(familleService.findOne(fam));
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		medicamentsService.create(medicament);
		return "redirect:/index";
	}
   // @Secured(value={"ROLE_ADMIN"})
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public String edit(Model model,Long id){
		Medicaments med;
		try {
			med = medicamentsService.findOne(id);
			model.addAttribute("medicament", med);
			model.addAttribute("famille", med.getFamille());
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "EditMedicament";
	}
	
	@RequestMapping("/login")
	public String login(Model model){
		return"Login";
	}
}
