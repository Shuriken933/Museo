package it.uniroma3.progettosiw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames={"nome","cognome"}))
public class Artista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String cognome;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private LocalDate DataDiNascita;
	
	@Column(nullable = false)
	private String LuogoDiNascita;
	
	private String LuogoDiMorte;
	private LocalDate DataDiMorte;
	
	@Column(nullable = false)
	private String nazionalità;
	
	@OneToMany(mappedBy = "artista")
	private List<Opera> opere;
	
	
	
	public String getLuogoDiMorte() {
		return LuogoDiMorte;
	}
	public void setLuogoDiMorte(String luogoDiMorte) {
		LuogoDiMorte = luogoDiMorte;
	}
	public LocalDate getDataDiMorte() {
		return DataDiMorte;
	}
	public void setDataDiMorte(LocalDate dataDiMorte) {
		DataDiMorte = dataDiMorte;
	}
	
}
