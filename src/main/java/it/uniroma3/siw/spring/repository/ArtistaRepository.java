package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Artista;

public interface ArtistaRepository extends CrudRepository<Artista, Long> {
	
	public List<Artista> findByNome(String nome);

}
