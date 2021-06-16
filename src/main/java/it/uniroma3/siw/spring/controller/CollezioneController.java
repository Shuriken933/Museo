package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.spring.controller.validator.CollezioneValidator;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.service.CollezioneService;
import it.uniroma3.siw.spring.service.CuratoreService;

@Controller
public class CollezioneController {
	
	@Autowired
	private CollezioneService collezioneService;
	
	@Autowired
	private CuratoreService curatoreService;
	
    @Autowired
    private CollezioneValidator collezioneValidator;
	
    
	@GetMapping(value = {"/collezioni", "/admin/collezioni"})
	public String getCollezioni(Model model) {
		model.addAttribute("collezioni", this.collezioneService.tutteCollezioni());
		model.addAttribute("curatori", this.curatoreService.tutti());
		return "collezioni.html";
	}
	
	@GetMapping(value = "/admin/gestisciCollezioni")
	public String getGestisciCollezioni(Model model) {
		// List<Opera> listaOpere = collezioneService.trovaTutteOpere();
		model.addAttribute("collezioni", this.collezioneService.tutteCollezioni());
		model.addAttribute("curatori", this.curatoreService.tutti());
		//model.addAttribute("listaOpere", listaOpere);
		model.addAttribute("collezione", new Collezione());
		return "admin/gestisciCollezioni";
	}
	
	@PostMapping("/admin/collezione")
    public String addCollezione(@ModelAttribute("collezione") Collezione collezione, Model model, BindingResult bindingResult) {
    	this.collezioneValidator.validate(collezione, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.collezioneService.inserisci(collezione);
        	model.addAttribute("collezioni", this.collezioneService.tutteCollezioni());
            return "redirect:/admin/gestisciCollezioni";
        }
        return "admin/gestisciCollezioni";
    }
	
	@GetMapping("collezione/delete/{id}")
	public String rimuoviCollezione(@PathVariable("id") Long id, Model model) {
		this.collezioneService.rimuoviCollezione(id);
		return "redirect:/admin/gestisciCollezioni"; 
	}
	
	@GetMapping("collezione/{id}")
	public String mostraCollezione(@PathVariable("id") Long id, Model model) {
		model.addAttribute("collezione", this.collezioneService.collezionePerId(id));
		return "collezione"; 
	}
	
	@PostMapping(value = {"/admin/modifica/collezione"})
	public String modificaOpera(@ModelAttribute("collezione") Collezione collezione, Model model, BindingResult bindingResult) {
		this.collezioneService.modificaCollezione(collezione);
		return "redirect:/admin/gestisciCollezioni";
	}

}
