package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CommercialExterne
 *
 */
@Entity
@Table(name="crm_cmexrh01")
public class CommercialExterne implements Serializable {

	
	private Long id;
	private Long numedoss;
	private Date datenais;
	private String matricul;
	private String nom;
	private String prenom;
	
	private TypeCommercialExterne typeCommercialExterne;
	private List<ObjectifCommercialExterne>  objectifCommercialExternes;
	
	private List<TravailExterne> travailExternes;
	
	
	private static final long serialVersionUID = 1L;
	
	
	public Long getNumedoss() {
		return numedoss;
	}
	public void setNumedoss(Long numedoss) {
		this.numedoss = numedoss;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDatenais() {
		return datenais;
	}
	public void setDatenais(Date datenais) {
		this.datenais = datenais;
	}
	public String getMatricul() {
		return matricul;
	}
	public void setMatricul(String matricul) {
		this.matricul = matricul;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public CommercialExterne() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	@ManyToOne
	public TypeCommercialExterne getTypeCommercialExterne() {
		return typeCommercialExterne;
	}
	public void setTypeCommercialExterne(TypeCommercialExterne typeCommercialExterne) {
		this.typeCommercialExterne = typeCommercialExterne;
	}
	
	@OneToMany(mappedBy="commercialExterne",cascade=CascadeType.ALL)
	public List<ObjectifCommercialExterne> getObjectifCommercialExternes() {
		return objectifCommercialExternes;
	}
	public void setObjectifCommercialExternes(
			List<ObjectifCommercialExterne> objectifCommercialExternes) {
		this.objectifCommercialExternes = objectifCommercialExternes;
	}
	
	@OneToMany(mappedBy="commercialExterne" ,cascade=CascadeType.ALL)
	public List<TravailExterne> getTravailExternes() {
		return travailExternes;
	}
	public void setTravailExternes(List<TravailExterne> travailExternes) {
		this.travailExternes = travailExternes;
	}
   
}
