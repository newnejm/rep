package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gtaparam.Libelle;



@Entity
@Table(name="pg_Description_poste")
public class Description_poste implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private int codedesc ;
	private List<TypeContrat> contrat_type;
	private List<Libelle> libelles;
	private Date horaire_standard ;
	private List<Poste> poste ;
	
	@Id   
	public int getCodedesc() {
		return codedesc;
	}
	
	public void setCodedesc(int codedesc) {
		this.codedesc = codedesc;
	}
	
	
	@OneToMany(mappedBy = "description_poste")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	
	

	@OneToMany(mappedBy="description_poste")
	public List<Poste> getPoste() {
		return poste;
	}

	public void setPoste(List<Poste> poste) {
		this.poste = poste;
	}

	@OneToMany(mappedBy = "description_poste")
	public List<TypeContrat> getContrat_type() {
		return contrat_type;
	}
	public void setContrat_type(List<TypeContrat> contrat_type) {
		this.contrat_type = contrat_type;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getHoraire_standard() {
		return horaire_standard;
	}
	public void setHoraire_standard(Date horaire_standard) {
		this.horaire_standard = horaire_standard;
	}
	
	
//	
	
}
