package it.uniroma3.siw.spring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.service.OperaService;


@Controller
public class MainController {
	
	@Autowired
	private OperaService operaService;
	
	/**
	 * Questi metodi gestiscono la navigazione delle pagine pubbliche
	 */
	
	@RequestMapping(value = {"/", "index", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("opere", this.operaService.tutteOpere());
		return "index";
	}
	
	@RequestMapping(value = {"/informazioni", "/admin/informazioni"}, method = RequestMethod.GET)
	public String getInformazioni(Model model) {
			return "informazioni.html";
	}
	
	@GetMapping(value = {"/risorse", "/admin/risorse"})
	public String getRisorse(Model model) {
			return "risorse.html";
	}
	

}