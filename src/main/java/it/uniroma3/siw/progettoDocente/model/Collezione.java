package it.uniroma3.siw.progettoDocente.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name="deleteCollezione" ,query="DELETE FROM Collezione c")
public class Collezione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private String nome;

	@Column
	private String descrizione;
	
	@OneToMany(mappedBy = "collezione")
	private List<Opera> opere;
	
	@ManyToOne
	private Curatore curatore;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
