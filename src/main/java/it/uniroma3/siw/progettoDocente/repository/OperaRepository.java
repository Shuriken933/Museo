package it.uniroma3.siw.progettoDocente.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.progettoDocente.model.Artista;
import it.uniroma3.siw.progettoDocente.model.Collezione;
import it.uniroma3.siw.progettoDocente.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long>{
	
	public List<Opera> deleteOpera(String titolo);
	
	public List<Opera> deleteAllOpere(Collezione collezione);
	
	public List<Opera> findByAutore(Artista autore);
	
	public List<Opera> findByAnno(LocalDate anno);

}
