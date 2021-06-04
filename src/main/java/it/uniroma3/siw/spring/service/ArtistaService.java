package it.uniroma3.siw.spring.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.repository.ArtistaRepository;

@Service
public class ArtistaService {
	
	@Autowired
	private ArtistaRepository artistaRepository; 
	
	@Transactional
	public Artista inserisci(Artista artista) {
		return artistaRepository.save(artista);
	}

	@Transactional
	public List<Artista> tutti() {
		return (List<Artista>) artistaRepository.findAll();
	}

	@Transactional
	public boolean alreadyExists(Artista artista) {
		List<Artista> artisti = this.artistaRepository.findByNome(artista.getNome());
		if (artisti.size() > 0)
			return true;
		else 
			return false;
	}

}
