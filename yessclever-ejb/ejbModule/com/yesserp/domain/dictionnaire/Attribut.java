package com.yesserp.domain.dictionnaire;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Attribut
 *
 */
@Entity
@Table(name = "dd_attribut")
@NamedQuery(name = "Attribut.findAll", query = "SELECT g FROM Attribut g")
public class Attribut implements Serializable {

	   
	
	private Long id;
	private String nomJava;
	private String nomBdd;
	private String type;
	private String contrainte;
	private String complexite;
	private String affichage;
	private String transcodage;
	private Long nbreOccurence;
	private Entite entite;
	private static final long serialVersionUID = 1L;
	
	public Attribut() {
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
	@ManyToOne
	@JoinColumn(name = "idEntite")
	public Entite getEntite() {
		return this.entite;
	}
	public void setEntite(Entite entite) {
		this.entite = entite;
	}

	public String getNomJava() {
		return nomJava;
	}

	public void setNomJava(String nomJava) {
		this.nomJava = nomJava;
	}

	public String getNomBdd() {
		return nomBdd;
	}

	public void setNomBdd(String nomBdd) {
		this.nomBdd = nomBdd;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContrainte() {
		return contrainte;
	}

	public void setContrainte(String contrainte) {
		this.contrainte = contrainte;
	}

	public String getComplexite() {
		return complexite;
	}

	public void setComplexite(String complexite) {
		this.complexite = complexite;
	}

	public String getAffichage() {
		return affichage;
	}

	public void setAffichage(String affichage) {
		this.affichage = affichage;
	}

	public String getTranscodage() {
		return transcodage;
	}

	public void setTranscodage(String transcodage) {
		this.transcodage = transcodage;
	}

	public Long getNbreOccurence() {
		return nbreOccurence;
	}

	public void setNbreOccurence(Long nbreOccurence) {
		this.nbreOccurence = nbreOccurence;
	}
	
   
}
