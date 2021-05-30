package it.uniroma3.siw.progettoDocente.controller.validator;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.progettoDocente.model.Collezione;
import it.uniromae3.siw.progettoDocente.service.CollezioneService;

public class CollezioneValidator implements Validator {
	
	@Autowired
	private CollezioneService collezioneService;
	
	private static final Logger logger = org.slf4j.LoggerFactory.getLogger(CollezioneValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return Collezione.class.equals(clazz);
	}

	@Override
	public void validate(Object o, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
		
		if(!errors.hasErrors()) {
			logger.debug("non ci sono valori nulli");
			if(this.collezioneService.alreadyExists((Collezione)o)) {
				logger.debug("già esiste");
				errors.reject("già esiste");
			}
		}
	}
}
