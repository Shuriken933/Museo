package it.uniroma3.siw.spring.model;

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
	private Long id;

	@Column(nullable = false)
	private String cognome;

	@Column(nullable = false)
	private String nome;

	private LocalDate dataDiNascita;

	private String luogoDiNascita;

	private String luogoDiMorte;
	private LocalDate dataDiMorte;

	private String biografia;

	private String nazionalità;

	@OneToMany(mappedBy = "artista")
	private List<Opera> opere;


	public void setNome(String nome) {this.nome = nome;}
	public void setCognome(String cognome) {this.cognome = cognome;}
	public void setDataDiNascita(LocalDate dataDiNascita) {this.dataDiNascita = dataDiNascita;}
	public void setLuogoDiNascita(String luogoDiNascita) {this.luogoDiNascita = luogoDiNascita;}
	public void setNazionalità(String nazionalità) {this.nazionalità = nazionalità;}
	public void setLuogoDiMorte(String luogoDiMorte) {this.luogoDiMorte = luogoDiMorte;}
	public void setDataDiMorte(LocalDate dataDiMorte) {this.dataDiMorte = dataDiMorte;}
	public void setBiografia(String biografia) {this.biografia = biografia;}
	
	public Long getId() {return id;}
	public String getNome() {return nome;}
	public String getCognome() {return cognome;}
	public LocalDate getDataDiNascita() {return dataDiNascita;}
	public String getLuogoDiNascita() {return luogoDiNascita;}
	public String getNazionalità() {return nazionalità;}
	public List<Opera> getOpere() {return opere;}
	public String getLuogoDiMorte() {return this.luogoDiMorte;}
	public LocalDate getDataDiMorte() {return this.dataDiMorte;}
	public String getBiografia() {return biografia;}

}
