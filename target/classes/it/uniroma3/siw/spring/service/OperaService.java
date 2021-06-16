package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

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

	@Transactional
	public void rimuoviOpera(Long id) {
		operaRepository.deleteById(id);
	}
	
	/*@SuppressWarnings("unlikely-arg-type")
	@Transactional
	public void rimuoviTutteOpereDiUnArtista(Long idArtista) {
		List<Opera> optional = (List<Opera>) operaRepository.findAll();
		for (Opera opera : optional) {
			if(opera.getArtista().equals(idArtista)) {
				operaRepository.delete(opera);
			}
		}
		
	}*/
	
	

	@Transactional
	public boolean alreadyExists(Opera opera) {
		List<Opera> opere = this.operaRepository.findByTitolo(opera.getTitolo());
		if(opere.size() >0)
			return true;
		else
			return false;
	}

	@Transactional
	public Opera operaPerId(Long id) {
		Optional<Opera> optional = operaRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public void modificaOpera(Opera opera) {
		Opera operaDaModificare = operaRepository.findById(opera.getId()).get();
		
		operaDaModificare.setTitolo(opera.getTitolo());
		operaDaModificare.setArtista(opera.getArtista());
		operaDaModificare.setAnnoDiRealizzazione(opera.getAnnoDiRealizzazione());
		operaDaModificare.setDescrizione(opera.getDescrizione());
		operaDaModificare.setCollezione(opera.getCollezione());
		
	}



	//
	//	@Transactional
	//	public List<Opera> rimuoviOpera(String nome ) {
	//		return operaRepository.deleteOpera(nome);
	//	}
}
