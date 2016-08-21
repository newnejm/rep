package com.yesserp.domain.dictionnaire;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Domaine
 *
 */
@Entity
@Table(name = "dd_domaine")
@NamedQuery(name = "Domaine.findAll", query = "SELECT g FROM Domaine g")
public class Domaine implements Serializable {

	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String nom;
	private List<Entite> entites;
	private Long nbreEntites;
	public Domaine() {
		super();
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	public Long getNbreEntites() {
		return nbreEntites;
	}
	public void setNbreEntites(Long nbreEntites) {
		this.nbreEntites = nbreEntites;
	}
	
	@OneToMany(mappedBy ="domaine", cascade = CascadeType.REMOVE)
	public List<Entite> getEntites() {
		return entites;
	}
	public void setEntites(List<Entite> entites) {
		this.entites = entites;
	}
	
   
}
