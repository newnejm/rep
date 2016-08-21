package com.yesserp.domain.pg;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gtaparam.Libelle;

/**
 * Entity implementation class for Entity: Type_PieceIdentite
 *
 */
@Entity
@Table(name="pg_TypePieceIdentite")
public class TypePieceIdentite implements Serializable {

	public TypePieceIdentite() {
		super();
	}   
	
	private Long id;
	private String nom;
	private List<Libelle> libelles;
	private static final long serialVersionUID = 1L;

	 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy = "typePieceIdentite")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
   
}
