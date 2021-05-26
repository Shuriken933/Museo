package it.uniroma3.siw.progettoDocente.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="deleteOpera", query="DELETE FROM opera o")
public class Opera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String titolo;

	@Column(nullable = false)
	private LocalDate AnnoDiRealizzazione;
	
	@Column(nullable = false)
	private String descrizione;
	
	@ManyToOne
	private Collezione collezione;
	
	@ManyToOne
	private Artista artista;
	
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
}
