package com.yesserp.domain.tm;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: DemandeFormation
 *
 */
@Entity
@Table(name="TM_DforRH")

public class DemandeFormation implements Serializable {

	
	private int code;
	private String libelle;
	private String reponse;
	private List<Identite> identites ;
	private Identite manager;
	private static final long serialVersionUID = 1L;

	public DemandeFormation() {
		super();
	}   
	@Id
	@GeneratedValue
	public int getCode() {
		return this.code;
	}

	
	public void setCode(int code) {
		this.code = code;
	}   
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	

	
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	@ManyToMany(mappedBy="demandes")
	public List<Identite> getIdentites() {
		return identites;
	}
	public void setIdentites(List<Identite> identites) {
		this.identites = identites;
	}
	
	
	@ManyToOne
	@JoinColumn(name="Manager")
	public Identite getManager() {
		return manager;
	}
	public void setManager(Identite manager) {
		this.manager = manager;
	}
   
	
	
	
}
