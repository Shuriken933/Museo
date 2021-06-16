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
	
	
	@Transactional
	public void rimuoviCollezione(Long id) {
		collezioneRepository.deleteById(id);
	}
	
	
	@Transactional
	public Collezione collezionePerId(Long id) {
		Optional<Collezione> optional = collezioneRepository.findById(id);
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

	@Transactional
	public void modificaCollezione(Collezione collezione) {
		Collezione collezioneDaModificare = collezioneRepository.findById(collezione.getId()).get();
		
		collezioneDaModificare.setNome(collezione.getNome());
		collezioneDaModificare.setCuratore(collezione.getCuratore());
		collezioneDaModificare.setDescrizione(collezione.getDescrizione());
		/*collezioneDaModificare.setAliasNome(collezione.getAliasNome());*/
		collezioneDaModificare.setOpere(collezione.getOpere());
		
	}

}
