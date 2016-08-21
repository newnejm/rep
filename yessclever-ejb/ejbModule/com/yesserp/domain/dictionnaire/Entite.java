package com.yesserp.domain.dictionnaire;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gf.DemandeFrais;

/**
 * Entity implementation class for Entity: Entite
 *
 */
@Entity
@Table(name = "dd_entite")
@NamedQuery(name = "Entite.findAll", query = "SELECT g FROM Entite g")
public class Entite implements Serializable {

	   
	
	private Long id;
	private String nom;
	private List<Attribut> attributs;
	private Domaine domaine;
	private Long nbreAttributs;
	private static final long serialVersionUID = 1L;

	public Entite() {
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

	@OneToMany(mappedBy ="entite", cascade = CascadeType.REMOVE)
	public List<Attribut> getAttributs() {
		return attributs;
	}

	public void setAttributs(List<Attribut> attributs) {
		this.attributs = attributs;
	}

	@ManyToOne
	@JoinColumn(name = "idDomaine")
	public Domaine getDomaine() {
		return domaine;
	}

	public void setDomaine(Domaine domaine) {
		this.domaine = domaine;
	}

	public Long getNbreAttributs() {
		return nbreAttributs;
	}

	public void setNbreAttributs(Long nbreAttributs) {
		this.nbreAttributs = nbreAttributs;
	}
	
	
	
   
}
