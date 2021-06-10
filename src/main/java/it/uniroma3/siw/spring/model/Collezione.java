package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Collezione {
	
	@Id
	/*@GeneratedValue(strategy = GenerationType.AUTO)*/
	@Column(unique = true, nullable = false)
	private String nome;
	
	private String aliasNome; // contiene il nome senza spazi

	@Column
	private String descrizione;
	
	@OneToMany(mappedBy = "collezione")
	private List<Opera> opere;
	
	@ManyToOne
	private Curatore curatore;
	

	public void setNome(String nome) {this.nome = nome;}
	/*public void setAliasNome(String nome) {this.aliasNome = nome.replaceAll("\\s+", "");}*/
	public void setDescrizione(String descrizione) {this.descrizione = descrizione;}
	public void setCuratore(Curatore curatore) {this.curatore = curatore;}
	
	public String getNome() {return nome;}
	public String getAliasNome() {
		aliasNome = nome.replaceAll("\\s+", "");
		return aliasNome;
		}
	public String getDescrizione() {return descrizione;}
	public Curatore getCuratore() {return curatore;}
	public List<Opera> getOpere() {return opere;}
}
