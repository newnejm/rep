package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Priorite_service
 *
 */
@Entity
@Table(name="crm_priorsrv01")
public class Priorite_service implements Serializable {

	
	private Integer id;
	private String nom;
	private List<Service> priorite_service;
	private static final long serialVersionUID = 1L;

	public Priorite_service() {
		super();
	}   
	@Id    
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	@OneToMany(mappedBy="priorite" , cascade=CascadeType.ALL)
	public List<Service> getPriorite_service() {
		return priorite_service;
	}
	public void setPriorite_service(List<Service> priorite_service) {
		this.priorite_service = priorite_service;
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
		Priorite_service other = (Priorite_service) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
   
}
