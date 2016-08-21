package com.yesserp.domain.gta;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class DebutSemaine implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id ;
	int idJourDeDebutSemaine;
	
	
	
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdJourDeDebutSemaine() {
		return idJourDeDebutSemaine;
	}
	public void setIdJourDeDebutSemaine(int idJourDeDebutSemaine) {
		this.idJourDeDebutSemaine = idJourDeDebutSemaine;
	}
	

}
