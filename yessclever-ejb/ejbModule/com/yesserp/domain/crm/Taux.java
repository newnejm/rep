package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Taux
 *
 */
@Entity
@Table(name="crm_tauxuf01")
public class Taux implements Serializable {

	
	private Long id;
	private int nom;
	private TypeTaxe typeTaxe;
    private List<TauxCompte> tauxComptes;


	private static final long serialVersionUID = 1L;

	public Taux() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public int getNom() {
		return this.nom;
	}

	public void setNom(int nom) {
		this.nom = nom;
	}
	
	
	@ManyToOne
	public TypeTaxe getTypeTaxe() {
		return typeTaxe;
	}
	public void setTypeTaxe(TypeTaxe typeTaxe) {
		this.typeTaxe = typeTaxe;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nom;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Taux other = (Taux) obj;
		if (nom != other.nom)
			return false;
		return true;
	}
	
	
	@OneToMany(mappedBy="taux",cascade=CascadeType.ALL)
	public List<TauxCompte> getTauxComptes() {
		return tauxComptes;
	}
	public void setTauxComptes(List<TauxCompte> tauxComptes) {
		this.tauxComptes = tauxComptes;
	}
	
	
	
	
   
}
