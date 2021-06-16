package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

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
	public void rimuoviArtista(Long id) {
		artistaRepository.deleteById(id);
	}
	
	@Transactional
	public void modificaArtista(Artista artista) {
		Artista artistaDaModificare = artistaRepository.findById(artista.getId()).get();
		
		artistaDaModificare.setNome(artista.getNome());
		artistaDaModificare.setCognome(artista.getCognome());
		artistaDaModificare.setDataDiNascita(artista.getDataDiNascita());
		artistaDaModificare.setLuogoDiNascita(artista.getLuogoDiNascita());
		artistaDaModificare.setNazionalita(artista.getNazionalita());
		artistaDaModificare.setLuogoDiMorte(artista.getLuogoDiMorte());
		artistaDaModificare.setDataDiMorte(artista.getDataDiMorte());
		artistaDaModificare.setBiografia(artista.getBiografia());
		artistaDaModificare.setImmagine(artista.getImmagine());

	}
	

	@Transactional
	public boolean alreadyExists(Artista artista) {
		List<Artista> artisti = this.artistaRepository.findByNome(artista.getNome());
		if (artisti.size() > 0)
			return true;
		else 
			return false;
	}

	public Artista artistaPerId(Long id) {
		Optional<Artista> optional = artistaRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	

}
