package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.model.Curatore;
import it.uniroma3.siw.spring.repository.CollezioneRepository;

@Service
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
	
	/*@Transactional
	public boolean rimuoviCollezione(String nome) {
		List<Collezione> optional = (List<Collezione>) collezioneRepository.findAll();
		if(optional.size() > 0) {
			collezioneRepository.deleteCollezione(nome);
			return true;
		}
		return false;
	}*/
	
	@Transactional
	public Collezione collezionePerNome(String nome) {
		Optional<Collezione> optional = collezioneRepository.findById(nome);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	@Transactional
	public boolean alreadyExists(Collezione collezione) {
		List<Collezione> collezioni = this.collezioneRepository.findByNome(collezione.getNome());
		if(collezioni.size() >0)
			return true;
		else
			return false;
	}

}
