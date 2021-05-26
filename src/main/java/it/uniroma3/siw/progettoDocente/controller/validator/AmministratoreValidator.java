package it.uniroma3.siw.progettoDocente.controller.validator;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class AmministratoreValidator {

	public boolean validate(HttpServletRequest request) {

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");

		Map<String,String> messaggiErrore=new HashMap<String,String>();

		if(!nome.equals("") && !cognome.equals("")) {

			return true;
		} else {
			if(nome.equals("")) {	
				messaggiErrore.put("nome", "Il nome è un campo obbligatorio");
				request.setAttribute("cognome", cognome);
			}
			if(cognome.equals("")) {

				messaggiErrore.put("cognome", "Il cognome è un campo obbligatorio");
				request.setAttribute("nome", nome);
			}
			request.setAttribute("errori", messaggiErrore);
			return false;
		}
	}
}