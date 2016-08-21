package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Type_travail_interne
 *
 */
@Entity
@Table(name="crm_tytrinrh01")
public class Origine implements Serializable {

	
	private int id;
	private String nom;
	private List<Service> services_origine;
	//private List<TravailInterne> travails_int ;
	private static final long serialVersionUID = 1L;

	public Origine() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@OneToMany(mappedBy="origine" , cascade=CascadeType.ALL)
	public List<Service> getServices_origine() {
		return services_origine;
	}
	public void setServices_origine(List<Service> services_origine) {
		this.services_origine = services_origine;
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
		Origine other = (Origine) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
   
}
