package it.uniroma3.progettosiw.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Museo {
	
	@OneToMany(mappedBy = "museo")
	private List<Collezione> collezioni;

}
