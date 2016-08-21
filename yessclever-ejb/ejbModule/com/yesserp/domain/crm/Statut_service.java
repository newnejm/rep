package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Statut
 *
 */
@Entity
@Table(name="crm_stat01")
public class Statut_service implements Serializable {

	
	private Integer id;
	private String nom;
	private List<Service> service_statut;
	private static final long serialVersionUID = 1L;

	public Statut_service() {
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
	@OneToMany(mappedBy="statut" , cascade=CascadeType.ALL)
	public List<Service> getService_statut() {
		return service_statut;
	}
	public void setService_statut(List<Service> service_statut) {
		this.service_statut = service_statut;
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
		Statut_service other = (Statut_service) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
   
}
