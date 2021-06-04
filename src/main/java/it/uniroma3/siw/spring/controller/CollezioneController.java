package it.uniroma3.siw.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CollezioneController {
	
	@RequestMapping(value = {"/collezioni"}, method = RequestMethod.GET)
	public String getCollezioni(Model model) {
			return "collezioni.html";
	}
	
	@RequestMapping(value = {"admin/gestisciCollezioni"}, method = RequestMethod.GET)
	public String getGestisciCollezioni(Model model) {
			return "admin/gestisciCollezioni";
	}

}
