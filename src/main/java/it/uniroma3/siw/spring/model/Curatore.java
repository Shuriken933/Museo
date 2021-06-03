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
	private String cognonome;
	
	@Column(nullable = false)
	private LocalDate dataDiNascita;
	
	@Column(nullable = false)
	private String LuogoDiNascita;
	
	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private Long numeroDiTelefono;

	@OneToMany(mappedBy = "curatore")
	private List<Collezione> collezioni;
}
