package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: NatureJournee
 *
 */
@Entity
@Table(name="GTA_NJP_UF01")
public class NatureJournee implements Serializable {

	
	private int idnj;
	private String codenj;
	private List<Libelle> libelles;
	private List<Filtre> filtres;
	private static final long serialVersionUID = 1L;

	public NatureJournee() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdnj() {
		return this.idnj;
	}

	public void setIdnj(int idnj) {
		this.idnj = idnj;
	}   
	public String getCodenj() {
		return this.codenj;
	}

	public void setCodenj(String codenj) {
		this.codenj = codenj;
	}
	@OneToMany(mappedBy="natureJournee")
	public List<Libelle> getLibelles() {
		return libelles;
	}
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	@ManyToMany(mappedBy="natureJournees")
	public List<Filtre> getFiltres() {
		return filtres;
	}
	public void setFiltres(List<Filtre> filtres) {
		this.filtres = filtres;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codenj == null) ? 0 : codenj.hashCode());
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
		NatureJournee other = (NatureJournee) obj;
		if (codenj == null) {
			if (other.codenj != null)
				return false;
		} else if (!codenj.equals(other.codenj))
			return false;
		return true;
	}
   
}
