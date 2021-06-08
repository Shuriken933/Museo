package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.CuratoreValidator;
import it.uniroma3.siw.spring.model.Curatore;
import it.uniroma3.siw.spring.service.CuratoreService;

@Controller
public class CuratoreController {
	
	@Autowired
	private CuratoreService curatoreService;
	
    @Autowired
    private CuratoreValidator curatoreValidator;
    
	@RequestMapping(value = {"/admin/addCuratore"}, method = RequestMethod.GET)
	public String addCuratore(Model model) {
		model.addAttribute("curatore", new Curatore());
		return "admin/curatoreForm";
	}
	
	@RequestMapping(value = {"curatori"}, method = RequestMethod.GET)
	public String getCuratori(Model model) {
//		model.addAttribute("curatore", new Curatore());
		model.addAttribute("curatori", this.curatoreService.tutti());
		return "admin/gestisciCuratori";
	}
	
	@RequestMapping(value = {"/admin/curatore"}, method = RequestMethod.POST)
    public String addCuratore(@ModelAttribute("curatore") Curatore curatore, 
    									Model model, BindingResult bindingResult) {
    	this.curatoreValidator.validate(curatore, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.curatoreService.inserisci(curatore);
            model.addAttribute("curatori", this.curatoreService.tutti());
            return "/admin/gestisciCuratori";
        }
        return "/admin/curatoreForm";
    }

}
