package it.uniroma3.siw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MainController {
	
	/**
	 * Questi metodi gestiscono la navigazione delle pagine pubbliche
	 */
	
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index(Model model) {
			return "index";
	}
	
	@RequestMapping(value = {"/artisti"}, method = RequestMethod.GET)
	public String getArtisti(Model model) {
			return "artisti.html";
	}
	
	@RequestMapping(value = {"/collezioni"}, method = RequestMethod.GET)
	public String getCollezioni(Model model) {
			return "collezioni.html";
	}
	
	@RequestMapping(value = {"/informazioni"}, method = RequestMethod.GET)
	public String getInformazioni(Model model) {
			return "informazioni.html";
	}
	
	@RequestMapping(value = {"/risorse"}, method = RequestMethod.GET)
	public String getRisorse(Model model) {
			return "risorse.html";
	}

	
	
	
	/**
	 * Questi metodi gestiscono la navigazione delle pagine amministratore
	 */
	
	@RequestMapping(value = {"/admin/gestisciOpere"}, method = RequestMethod.GET)
	public String getGestisciOpere(Model model) {
			return "gestisciOpere.html";
	}
	
	@RequestMapping(value = {"/admin/gestisciArtisti"}, method = RequestMethod.GET)
	public String getGestisciArtisti(Model model) {
			return "gestisciArtisti.html";
	}
	
	@RequestMapping(value = {"/admin/gestisciCuratori"}, method = RequestMethod.GET)
	public String getGestisciCuratori(Model model) {
			return "gestisciCuratori.html";
	}
	
	@RequestMapping(value = {"/admin/gestisciCollezioni"}, method = RequestMethod.GET)
	public String getGestisciCollezioni(Model model) {
			return "gestisciCollezioni.html";
	}
}