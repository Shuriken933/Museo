package it.uniroma3.siw.progettoDocente.controller.validator;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.progettoDocente.model.Opera;
import it.uniromae3.siw.progettoDocente.service.OperaService;

public class OperaValidator implements Validator {
	
	@Autowired
	private OperaService operService;
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(OperaValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return Opera.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		
		if(!errors.hasErrors()) {
			logger.debug("non ci sono valori nulli");
			if(this.operService.alreadyExists((Opera)o)) {
				logger.debug("già esiste");
				errors.reject("già esiste");
			}
		}
	}
}
