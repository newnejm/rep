package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Langue
 * 
 */
@Entity
public class Langue implements Serializable {

	private int idl;
	private String codel;
	private String libelle;
	private List<Libelle> libelles;
	private static final long serialVersionUID = 1L;

	public Langue() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdl() {
		return this.idl;
	}

	public void setIdl(int idl) {
		this.idl = idl;
	}

	public String getCodel() {
		return this.codel;
	}

	public void setCodel(String codel) {
		this.codel = codel;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@OneToMany(mappedBy = "langue")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

}
