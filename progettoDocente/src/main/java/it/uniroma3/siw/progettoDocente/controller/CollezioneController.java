package it.uniroma3.siw.progettoDocente.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.progettoDocente.controller.validator.CollezioneValidator;
import it.uniroma3.siw.progettoDocente.model.Collezione;
import it.uniromae3.siw.progettoDocente.service.CollezioneService;
import it.uniromae3.siw.progettoDocente.service.OperaService;

@Controller
public class CollezioneController {

	@Autowired
	private CollezioneService collezioneService;
	
	@Autowired
	private OperaService operaService;
	
	@Autowired
	private CollezioneValidator collezioneValidator;
	
	@RequestMapping(value="/addCollezione", method = RequestMethod.GET)
	public String addCollezione(Model model) {
		model.addAttribute("collezione", new Collezione());
		return "collezioneForm";
	}
	
	@RequestMapping(value="/collezione", method = RequestMethod.GET)
	public String getCollezioni(Model model) {
		model.addAttribute("collezioni", this.collezioneService.tutteCollezioni());
		return "collezioni.html";
	}
	
	@RequestMapping(value="/collezione/{nome}", method = RequestMethod.GET)
	public String getPersona(String nome, Model model) {
		model.addAttribute("collezione", this.collezioneService.collezionePerNome(nome));
		return "collezione.html";
	}
	
	@RequestMapping(value="/collezione", method = RequestMethod.POST)
	public String newCollezione(@ModelAttribute("collezione") Collezione collezione,	//modelAttribute mi dice che l'oggettp collezione è presente già nel model e viene scambiato tra il controller e la vista
										Model model, BindingResult bindingResult) {
		this.collezioneValidator.validate(collezione, bindingResult);				//in binding result ci vengono messi i risultati della validazione
		if(!bindingResult.hasErrors() ) {
			this.collezioneService.inserisci(collezione);
			model.addAttribute("collezione", this.collezioneService.tutteCollezioni());
			return "collezione.html";
		}
		return "collezioneForm.html";
	}
	
	@RequestMapping(value="/collezione/{nome}", method = RequestMethod.GET)									// non sicuro sia giusto
	public String removeCollezione(@PathVariable("nome") String nome, Model model) {
		if(nome != null) {
			operaService.rimuoviTutteOpere();
			collezioneService.rimuoviCollezione(nome);
		}
		model.addAttribute("collezione", this.collezioneService.collezionePerNome(nome));
		return "collezioni.html";
	}
}
