package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.validator.OperaValidator;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.service.OperaService;

@Controller
public class OperaController {
	
	@Autowired
	private OperaService operaService;
	
	@Autowired
	private OperaValidator operaValidator;
	
	@RequestMapping(value="/admin/addOpera", method = RequestMethod.GET)
	public String addOpera(Model model) {
		model.addAttribute("opera", new Opera());
		return "admin/operaForm";
	}
	
	@RequestMapping(value="/opere", method = RequestMethod.GET)
	private String getOpere(Model model) {
		model.addAttribute("opere", this.operaService.tutteOpere());
		return "admin/gestisciOpere";
	}
	
//	@RequestMapping(value="/opera/{titolo}", method = RequestMethod.GET)
//	private String getOpera(@PathVariable("titolo") String titolo, Model model) {
//		model.addAttribute("opera", this.operaService.trovaPerTitolo(titolo));
//		return "opera.html";
//	}
	
    @RequestMapping(value = "/admin/opera", method = RequestMethod.POST)
    public String addOpera(@ModelAttribute("opera") Opera opera,
    									Model model, BindingResult bindingResult) {
    	this.operaValidator.validate(opera, bindingResult);
        if (!bindingResult.hasErrors()) {
        	this.operaService.inserisci(opera);
            model.addAttribute("opere", this.operaService.tutteOpere());
            return "opera";
        }
        return "admin/operaForm";
    }
    
//	@RequestMapping(value="/opera/{titolo}", method = RequestMethod.GET)									// non sicuro sia giusto
//	public String removeOpera(@PathVariable("titolo") String titolo, Model model) {
//		if(titolo != null) {
//			operaService.rimuoviOpera(titolo);
//		}
//		model.addAttribute("opera", this.operaService.tutteOpere());
//		return "collezione.html";
//	}
}