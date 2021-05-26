package it.uniromae3.siw.progettoDocente.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import it.uniroma3.siw.progettoDocente.model.Collezione;
import it.uniroma3.siw.progettoDocente.model.Curatore;
import it.uniroma3.siw.progettoDocente.repository.CollezioneRepository;

public class CollezioneService {
	
	@Autowired
	private CollezioneRepository collezioneRepository;
	
	@Transactional
	public Collezione inserisci(Collezione collezione) {
		return collezioneRepository.save(collezione);
	}
	
	@Transactional
	public List<Collezione> tutteCollezioni() {
		return (List<Collezione>) collezioneRepository.findAll();
	}
	
	@Transactional
	public List<Collezione> trovaPerNome(String nome) {
		return collezioneRepository.findByNome(nome);
	}
	
	@Transactional
	public List<Collezione> trovaPerCuratore(Curatore curatore) {
		return collezioneRepository.findByCuratore(curatore);
	}
	
	@Transactional
	public List<Collezione> rimuoviCollezione(String nome) {
		return collezioneRepository.deleteInformations(nome);
	}

}
