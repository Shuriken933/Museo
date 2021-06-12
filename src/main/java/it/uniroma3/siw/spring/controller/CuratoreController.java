package it.uniroma3.siw.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import it.uniroma3.siw.spring.controller.validator.CuratoreValidator;
import it.uniroma3.siw.spring.model.Curatore;
import it.uniroma3.siw.spring.service.CuratoreService;

@Controller
public class CuratoreController {
	
	@Autowired
	private CuratoreService curatoreService;
	
    @Autowired
    private CuratoreValidator curatoreValidator;
    
    //private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @GetMapping("/admin/gestisciCuratori")
	public String getGestisciCuratori(Model model) {
		model.addAttribute("curatori", this.curatoreService.tutti());
		model.addAttribute("curatore", new Curatore());
		return "admin/gestisciCuratori";
	}
	
	@PostMapping("/admin/curatore")
    public String addCuratore(@ModelAttribute("curatore") Curatore curatore, Model model, BindingResult bindingResult) {
    	this.curatoreValidator.validate(curatore, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.curatoreService.inserisci(curatore);
        	model.addAttribute("curatori", this.curatoreService.tutti());
            return "redirect:/admin/gestisciCuratori";
        }
        return "admin/gestisciCuratori";
    }
	

}
