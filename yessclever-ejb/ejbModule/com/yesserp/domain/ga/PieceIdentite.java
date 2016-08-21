package com.yesserp.domain.ga;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: PieceIdentite
 *
 */
@Entity
@Table(name = "ga_piecIden01")
@NamedQuery(name = "PieceIdentite.findAll", query = "SELECT g FROM PieceIdentite g")
public class PieceIdentite implements Serializable {

	   
	
	private Long id;
	private String valeur;
	private String type;
	private Identite identite;
	private static final long serialVersionUID = 1L;

	public PieceIdentite() {
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
	public String getValeur() {
		return this.valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToOne
	@JoinColumn(name="dossempl")
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
   
}
