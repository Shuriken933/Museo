package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Curatore;

public interface CuratoreRepository extends CrudRepository<Curatore, Long> { // <Curatore, String>
	
	public List<Curatore> findByNome(String nome);
	
	public List<Curatore> findByNomeAndCognome(String nome, String cognome);

}
