package it.uniroma3.siw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
	
	/**
	 * Questi metodi gestiscono la navigazione delle pagine pubbliche
	 */
	
	@RequestMapping(value = {"/", "index", "/index"}, method = RequestMethod.GET)
	public String index(Model model) {
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
	

	
	/**
	 * Questi metodi gestiscono la navigazione delle pagine amministratore
	 */
	
	
	
	
	
	

}