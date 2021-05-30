package it.uniroma3.siw.progettoDocente.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.progettoDocente.model.Collezione;
import it.uniroma3.siw.progettoDocente.model.Curatore;

public interface CollezioneRepository extends CrudRepository<Collezione, String> {
	
	public List<Collezione> deleteCollezione(String nome);
	
	public List<Collezione> findByCuratore(Curatore curatore);
	
	public List<Collezione> findByNome(String nome);

}
