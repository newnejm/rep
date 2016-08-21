package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.lang.Integer;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: FilsCompteur
 *
 */
@Entity

public class FilsCompteur implements Serializable {

	   
	
	private Integer id;
	private Integer idFils;
	private static final long serialVersionUID = 1L;
private Compteur compteur;
	
	public FilsCompteur() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public Integer getIdFils() {
		return this.idFils;
	}

	public void setIdFils(Integer idFils) {
		this.idFils = idFils;
	}

	
	@ManyToOne
	public Compteur getCompteur() {
		return compteur;
	}

	public void setCompteur(Compteur compteur) {
		this.compteur = compteur;
	}
   
}
