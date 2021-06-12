package it.uniroma3.siw.spring.model;


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
	private Long id;
	
	@Column(unique = true, nullable = false)
	private String titolo;

	@Column
	private Integer annoDiRealizzazione;
	
	@Column
	private String descrizione;
	
	@ManyToOne
	private Collezione collezione;
	
	@ManyToOne
	private Artista artista;
	
	
	public Long getId() {return id;}
	public String getTitolo() {return titolo;}
	public Integer getAnnoDiRealizzazione() {return annoDiRealizzazione;}
	public Artista getArtista() {return artista;}
	public Collezione getCollezione() {return collezione;}
	public String getDescrizione() {return descrizione;}

	public void setId(Long id) {this.id = id;}
	public void setTitolo(String titolo) {this.titolo = titolo;}
	public void setAnnoDiRealizzazione(Integer annoDiRealizzazione) {this.annoDiRealizzazione = annoDiRealizzazione;}
	public void setArtista(Artista artista) {this.artista = artista;}
	public void setCollezione(Collezione collezione) {this.collezione = collezione;}
	public void setDescrizione(String descrizione) {this.descrizione = descrizione;}
}
