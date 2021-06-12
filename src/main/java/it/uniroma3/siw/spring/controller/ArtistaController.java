package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.ArtistaValidator;
import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.repository.ArtistaRepository;
import it.uniroma3.siw.spring.service.ArtistaService;

@Controller
public class ArtistaController {

	@Autowired
	private ArtistaService artistaService;

	@Autowired
	private ArtistaValidator artistaValidator;

	@Autowired
	private ArtistaRepository artistaRepository;
	

	/* metodi commentati perhcè nel progetto non è richiesto l'add di un nuovo artista */

	@RequestMapping(value = {"/admin/gestisciArtisti"}, method = RequestMethod.GET)
	public String getGestisciArtisti(Model model) {
		model.addAttribute("artisti", this.artistaService.tutti());
		model.addAttribute("artista", new Artista());
		return "admin/gestisciArtisti";
	}


	/*@RequestMapping(value="/admin/addArtista", method = RequestMethod.GET)
    public String addArtista(Model model) {
    	model.addAttribute("artista", new Artista());
        return "admin/artistaForm";
    }*/

	@RequestMapping(value = {"artisti"/*, "/admin/artisti"*/}, method = RequestMethod.GET)
	public String getArtisti(Model model) {
		model.addAttribute("artisti", this.artistaService.tutti());
		return "artisti";
	}
	
	@GetMapping("artista/{id}")
	public String getArtista(@PathVariable("id") Long id, Model model) {
		this.artistaRepository.findById(id);
		model.addAttribute("artista", this.artistaService.artistaPerId(id));
		return "artista";
	}


	@RequestMapping(value = {"/admin/artista"}, method = RequestMethod.POST)
	public String addArtista(@ModelAttribute("artista") Artista artista, 
			Model model, BindingResult bindingResult) {
		this.artistaValidator.validate(artista, bindingResult);
		if (!bindingResult.hasErrors()) {
			this.artistaService.inserisci(artista);
			model.addAttribute("artisti", this.artistaService.tutti());
			return "redirect:/admin/gestisciArtisti";
		}
		return "admin/artistaForm";
	}
	
	@RequestMapping(value = {"/modifica-artista/{id}"}, method = RequestMethod.POST)
	public String modifyArtista(@PathVariable("id") Long id, Model model, BindingResult bindingResult) {
		this.artistaRepository.findById(id);
		Artista artista = this.artistaService.artistaPerId(id);
		model.addAttribute("artista", artista);
		//model.addAttribute("artista", this.artistaService.tutti());
		/*artistaApp.setNome(null);
		artistaApp.setCognome(null);
		artistaApp.setBiografia(null);
		artistaApp.setDataDiNascita(null);
		artistaApp.setLuogoDiNascita(null);
		artistaApp.setDataDiMorte(null);
		artistaApp.setLuogoDiMorte(null);
		artistaApp.setNazionalita(null);
		model.addAttribute("artista", this.artistaService.tutti());*/
		return "redirect:/admin/gestisciArtisti";

	}

	@GetMapping("artista/delete/{id}")
	public String rimuoviArtista(@PathVariable("id") Long id, Model model) {
		this.artistaService.rimuoviArtista(id);
		return "redirect:/admin/gestisciArtisti"; 
	}

}
