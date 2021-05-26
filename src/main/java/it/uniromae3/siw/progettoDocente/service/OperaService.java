package it.uniromae3.siw.progettoDocente.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import it.uniroma3.siw.progettoDocente.model.Artista;
import it.uniroma3.siw.progettoDocente.model.Opera;
import it.uniroma3.siw.progettoDocente.repository.OperaRepository;

public class OperaService {

	@Autowired
	private OperaRepository operaRepository;

	@Transactional
	public Opera inserisci(Opera opera) {
		return operaRepository.save(opera);
	}

	@Transactional
	public List<Opera> tutteOpere() {
		return (List<Opera>) operaRepository.findAll();
	}

	@Transactional
	public List<Opera> trovaPerAutore(Artista autore) {
		return operaRepository.findByAutore(autore);
	}

	@Transactional
	public List<Opera> trovaPerAnno(LocalDate anno) {
		return operaRepository.findByAnno(anno);
	}

	@Transactional
	public boolean rimuoviOpera(String nome) {
		List<Opera> optional = (List<Opera>) operaRepository.findAll();
		if(optional.size() > 0) {
			operaRepository.deleteOpera(nome);
			return true;
			} 
		return false;
	}

//
//	@Transactional
//	public List<Opera> rimuoviOpera(String nome ) {
//		return operaRepository.deleteOpera(nome);
//	}
}
