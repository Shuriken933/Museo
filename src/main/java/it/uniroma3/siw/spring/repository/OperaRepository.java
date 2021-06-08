package it.uniroma3.siw.spring.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.model.Collezione;
import it.uniroma3.siw.spring.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, String>{
	
//	public List<Opera> deleteOpera(String titolo);
//	
//	public List<Opera> deleteAllOpere(Collezione collezione);
//	
//	public List<Opera> findByAutore(Artista autore);
//	
//	public List<Opera> findByAnno(LocalDate anno);
//	
	public List<Opera> findByTitolo(String titolo);

}
