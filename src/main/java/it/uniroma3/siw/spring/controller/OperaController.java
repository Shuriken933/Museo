package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.OperaValidator;
import it.uniroma3.siw.spring.model.Opera;
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
	
	/*@GetMapping(value = {"/admin/gestisciOpere"})
	public String getGestisciOpere(Model model) {
			return "admin/gestisciOpere";
	}*/
	
	@GetMapping(value = "/admin/gestisciOpere")
	public String getGestisciCollezioni(Model model) {
		model.addAttribute("opere", this.operaService.tutteOpere());
		model.addAttribute("artisti", this.artistaService.tutti());
		model.addAttribute("collezioni", this.collezioneService.tutteCollezioni());
		model.addAttribute("opera", new Opera());
		return "admin/gestisciOpere";
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

}
