package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.model.Opera;

public interface OperaRepository extends CrudRepository<Opera, Long>{
	
	/*public List<Opera> deleteOpera(String titolo);*/
	
	/*public List<Opera> deleteAllOpere(Collezione collezione);*/
	
	public List<Opera> findByArtista(Artista artista);
	
	
	/*public boolean rimuoviTutteOpereDiUnArtista(Long idArtista);*/
	
	/*public List<Opera> findByAnno(Integer annoDiRealizzazione);*/
	
	public List<Opera> findByTitolo(String titolo);

}
