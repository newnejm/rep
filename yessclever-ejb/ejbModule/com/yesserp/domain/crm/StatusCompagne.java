package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: StatusCompagne
 *
 */
@Entity
@Table(name="crm_sttsuf01")
public class StatusCompagne implements Serializable {

	   

	private Long idStatus;
	private String Libelle;
	private List<Compagne> compagnes;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Libelle == null) ? 0 : Libelle.hashCode());
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
		StatusCompagne other = (StatusCompagne) obj;
		if (Libelle == null) {
			if (other.Libelle != null)
				return false;
		} else if (!Libelle.equals(other.Libelle))
			return false;
		return true;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	private static final long serialVersionUID = 1L;

	public StatusCompagne() {
		super();
	} 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdStatus() {
		return this.idStatus;
	}

	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}
	
	@OneToMany(mappedBy="status",cascade=CascadeType.ALL)
	public List<Compagne> getCompagnes() {
		return compagnes;
	}
	public void setCompagnes(List<Compagne> compagnes) {
		this.compagnes = compagnes;
	}
   
}
