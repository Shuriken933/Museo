package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.OperaValidator;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.repository.OperaRepository;
import it.uniroma3.siw.spring.service.ArtistaService;
import it.uniroma3.siw.spring.service.CollezioneService;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	private OperaService operaService;
	
	@Autowired
	private OperaValidator operaValidator;
	
	@Autowired
	private ArtistaService artistaService;
	@Autowired
	private CollezioneService collezioneService;
	
	@Autowired
	private OperaRepository operaRepository;
	
	@GetMapping(value = "/admin/gestisciOpere")
	public String getGestisciCollezioni(Model model) {
		model.addAttribute("opere", this.operaService.tutteOpere());
		model.addAttribute("artisti", this.artistaService.tutti());
		model.addAttribute("collezioni", this.collezioneService.tutteCollezioni());
		model.addAttribute("opera", new Opera());
		return "admin/gestisciOpere";
	}
	
	@GetMapping({"opera/{id}"/*, "admin/opera/{id}"*/})
	public String getOpera(@PathVariable("id") Long id, Model model) {
		this.operaRepository.findById(id);
		model.addAttribute("opera", this.operaService.operaPerId(id));
		return "opera";
	}
	
	@RequestMapping(value = "/admin/opera", method = RequestMethod.POST)
    public String addOpera(@ModelAttribute("opera") Opera opera, Model model, BindingResult bindingResult) {
    	this.operaValidator.validate(opera, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.operaService.inserisci(opera);
        	model.addAttribute("opere", this.operaService.tutteOpere());
            return "admin/gestisciOpere";
        }
        
        return "admin/gestisciOpere";
    }
	
	@PostMapping(value = {"/admin/modifica/opera"})
	public String modifyOpera(@ModelAttribute("opera") Opera opera, Model model, BindingResult bindingResult) {

		
		this.operaService.modificaOpera(opera);
		return "redirect:/admin/gestisciOpere";

	}
	
	@GetMapping("opera/delete/{id}")
	public String rimuoviOpera(@PathVariable("id") Long id, Model model) {
		this.operaService.rimuoviOpera(id);
		return "redirect:/admin/gestisciOpere"; 
	}

}


