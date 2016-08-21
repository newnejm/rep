package com.yesserp.domain.crm;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: TypeCompagne
 * 
 */
@Entity
@Table(name = "crm_tycgrh01")
public class TypeCompagne implements Serializable {

	private Long id;
	private String nom;

	private List<Compagne> compagnes;

	private static final long serialVersionUID = 1L;

	public TypeCompagne() {
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
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy = "typeCompagne", cascade = CascadeType.ALL)
	public List<Compagne> getCompagnes() {
		return compagnes;
	}

	public void setCompagnes(List<Compagne> compagnes) {
		this.compagnes = compagnes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		TypeCompagne other = (TypeCompagne) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

}
