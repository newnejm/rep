package com.yesserp.domain.pg;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gtaparam.Libelle;

/**
 * Entity implementation class for Entity: NatureContratIdentite
 *
 */
@Entity
@Table(name="pg_natureContratIdentite")
public class NatureContratIdentite implements Serializable {

	
	private Long id;
	private String nom;
	private List<Libelle> libelles;
	private static final long serialVersionUID = 1L;

	public NatureContratIdentite() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy = "natureContratIdentite")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
   
   
}
