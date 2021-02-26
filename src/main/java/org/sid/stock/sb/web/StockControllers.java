package org.sid.stock.sb.web;

import java.util.List;

import org.sid.stock.sb.entities.Stock;
import org.sid.stock.sb.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class StockControllers {
	
	@Autowired
	private StockService stockService;
	
	@RequestMapping(value="/tables", method=RequestMethod.GET)
	public String stock(Model model){
	List<Stock> stock = stockService.findAll();
	model.addAttribute("stock", stock);
	return "Stock";
	
	}
	
	@RequestMapping(value="/statistique", method=RequestMethod.GET)
	public String statistique(Model model){
	List<Stock> stock = stockService.findAll();
	model.addAttribute("stock", stock);
	return "Statistique";
	
	}
}
