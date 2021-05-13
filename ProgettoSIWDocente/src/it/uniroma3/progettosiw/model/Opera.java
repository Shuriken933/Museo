package it.uniroma3.progettosiw.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Opera {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long titolo;
	
	@Column(nullable = false)
	private LocalDate AnnoDiRealizzazione;
	
	@Column(nullable = false)
	private String descrizione;
	
	@ManyToOne
	private Collezione collezione;
	
	@ManyToOne
	private Artista artista;
	
}
