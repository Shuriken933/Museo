package it.uniroma3.siw.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Artista;
import it.uniroma3.siw.spring.model.Opera;
import it.uniroma3.siw.spring.repository.OperaRepository;

@Service
public class OperaService {

	@Autowired
	private OperaRepository operaRepository;

	@Transactional
	public Opera inserisci(Opera opera) {
		return operaRepository.save(opera);
	}

	@Transactional
	public List<Opera> tutteOpere() {
		return (List<Opera>) operaRepository.findAll();
	}

	@Transactional
	public List<Opera> trovaPerArtista(Artista artista) {
		return operaRepository.findByArtista(artista);
	}

	/*@Transactional
	public List<Opera> trovaPerAnno(Integer annoDiRealizzazione) {
		return operaRepository.findByAnno(annoDiRealizzazione);
	}*/

	@Transactional
	public List<Opera> trovaPerTitolo(String titolo) {
		return operaRepository.findByTitolo(titolo);
	}

	/*@Transactional
	public boolean rimuoviOpera(String nome) {
		List<Opera> optional = (List<Opera>) operaRepository.findAll();
		if(optional.size() > 0) {
			operaRepository.deleteOpera(nome);
			return true;
		} 
		return false;
	}

	@Transactional
	public boolean rimuoviTutteOpere() {
		List<Opera> optional = (List<Opera>) operaRepository.findAll();
		if(optional.size() > 0) {
			operaRepository.deleteAll();
			return true;
		} 
		return false;
	}*/

		@Transactional
		public boolean alreadyExists(Opera opera) {
			List<Opera> opere = this.operaRepository.findByTitolo(opera.getTitolo());
			if(opere.size() >0)
				return true;
			else
				return false;
		}


		//
		//	@Transactional
		//	public List<Opera> rimuoviOpera(String nome ) {
		//		return operaRepository.deleteOpera(nome);
		//	}
	}
