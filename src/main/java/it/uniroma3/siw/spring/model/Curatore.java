package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Curatore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long matricola;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private LocalDate dataDiNascita;
	
	@Column(nullable = false)
	private String luogoDiNascita;
	
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private Long numeroDiTelefono;

	@OneToMany(mappedBy = "curatore")
	private List<Collezione> collezioni;
	
	
	public String getNome() {return nome;}
	public String getCognome() {return cognome;}
	public List<Collezione> getCollezioni() {return collezioni;}
	public LocalDate getDataDiNascita() {return dataDiNascita;}
	public String getEmail() {return email;}
	public String getLuogoDiNascita() {return luogoDiNascita;}
	public Long getMatricola() {return matricola;}
	public Long getNumeroDiTelefono() {return numeroDiTelefono;}
	
	public void setNome(String nome) {this.nome = nome;}
	public void setCognome(String cognome) {this.cognome = cognome;}
	public void setDataDiNascita(LocalDate dataDiNascita) {this.dataDiNascita = dataDiNascita;}
	public void setEmail(String email) {this.email = email;}
	public void setLuogoDiNascita(String luogoDiNascita) {this.luogoDiNascita = luogoDiNascita;}
	public void setNumeroDiTelefono(Long numeroDiTelefono) {this.numeroDiTelefono = numeroDiTelefono;}
}
