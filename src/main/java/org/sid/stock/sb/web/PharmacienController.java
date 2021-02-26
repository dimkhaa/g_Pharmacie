package org.sid.stock.sb.web;

import java.util.List;

import org.sid.stock.sb.entities.Pharmacien;
import org.sid.stock.sb.service.PharmacienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javassist.NotFoundException;

@Controller
public class PharmacienController {
	@Autowired
	private PharmacienService pharmacienService;

	@GetMapping(value = "/pharmacien")
	public String pharmaciens(Model model) {
		List<Pharmacien> pharmaciens = pharmacienService.findAll();
		model.addAttribute("listPharmaciens", pharmaciens);
		return "pharmaciens";
	}

	@RequestMapping(value = "/ajoutpharmacien", method = RequestMethod.GET)
	public String ajuterpharmacien(Model model) {
		model.addAttribute("pharmacien", new Pharmacien());
		return "AjoutPharmacien";
	}

	@RequestMapping(value = "/Suppharmacien", method = RequestMethod.GET)
	public String deletepharmacien(Long id) {
		pharmacienService.removeById(id);
		return "redirect:/pharmacien";
	}

	@RequestMapping(value = "/savepharmacien", method = RequestMethod.POST)
	public String enregistrerPharmacien(Model model, Pharmacien p) {
		pharmacienService.create(p);
		return "redirect:/pharmacien";
	}

	@RequestMapping(value = "/editpharmacien", method = RequestMethod.GET)
	public String editpharmacien(Model model, Long id) {
		Pharmacien p;
		try {
			p = pharmacienService.findOne(id);
			model.addAttribute("pharmacien", p);
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "EditPharmacien";
	}
}