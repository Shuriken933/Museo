package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.ArtistaValidator;
import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.service.ArtistaService;

@Controller
public class ArtistaController {
	
	@Autowired
	private ArtistaService artistaService;
	
	@Autowired
	private ArtistaValidator artistaValidator;
	
	@RequestMapping(value = {"/artisti"}, method = RequestMethod.GET)
	public String getArtisti(Model model) {
			return "artisti.html";
	}
	
	/*@RequestMapping(value = {"/admin/gestisciArtisti"}, method = RequestMethod.GET)
	public String getGestisciArtisti(Model model) {
		model.addAttribute("artisti", this.artistaService.tutti());
			return "admin/gestisciArtisti";
	}*/
	
	
	/*@RequestMapping(value = {"/admin/gestisciArtisti"}, method = RequestMethod.POST)
    public String addArtista(@ModelAttribute("artista") Artista artista, 
    									Model model, BindingResult bindingResult) {
    	this.artistaValidator.validate(artista, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.artistaService.inserisci(artista);
            model.addAttribute("artisti", this.artistaService.tutti());
            return "artisti";
        }
        return "admin/gestisciArtisti";
    }*/

}
