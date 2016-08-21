package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Devise
 *
 */
@Entity
@Table(name="crm_deviseuf01")
public class Devise implements Serializable {

	   

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
		Devise other = (Devise) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	private Long id;
	private String nom;
	private List<Marketing>marketing;
	
	private static final long serialVersionUID = 1L;

	public Devise() {
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@OneToMany(mappedBy="devise",cascade=CascadeType.ALL)
	public List<Marketing> getMarketing() {
		return marketing;
	}
	public void setMarketing(List<Marketing> marketing) {
		this.marketing = marketing;
	}

   
}
