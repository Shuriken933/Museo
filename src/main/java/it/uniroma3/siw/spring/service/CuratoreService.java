package it.uniroma3.siw.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Curatore;
import it.uniroma3.siw.spring.repository.CuratoreRepository;

@Service
public class CuratoreService {
	
	@Autowired
	private CuratoreRepository curatoreRepository; 
	
	@Transactional
	public Curatore inserisci(Curatore curatore) {
		return curatoreRepository.save(curatore);
	}

	@Transactional
	public List<Curatore> tutti() {
		return (List<Curatore>) curatoreRepository.findAll();
	}

	@Transactional
	public boolean alreadyExists(Curatore curatore) {
		List<Curatore> curatori = this.curatoreRepository.findByNome(curatore.getNome());
		if (curatori.size() > 0)
			return true;
		else 
			return false;
	}

}
