package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Vehicule
 * 
 */
@Entity
@Table(name = "ga_vehirh01")
public class Vehicule implements Serializable {

	private Long id;
	private String immatriculation;
	private String typeVehicule;
	private String marque;
	private String consommation;
	private String puissance;
	private Date datedeb;
	private Date datefin;
	private Identite identite;
	private static final long serialVersionUID = 1L;

	public Vehicule() {
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

	@Column(name="immatric")
	public String getImmatriculation() {
		return this.immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	@Column(name="typevehi")
	public String getTypeVehicule() {
		return this.typeVehicule;
	}

	public void setTypeVehicule(String typeVehicule) {
		this.typeVehicule = typeVehicule;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatedeb() {
		return this.datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	@ManyToOne
	@JoinColumn(name = "dossempl")
	public Identite getIdentite() {
		return this.identite;
	}	
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Column(name="consomma")
	public String getConsommation() {
		return consommation;
	}

	public void setConsommation(String consommation) {
		this.consommation = consommation;
	}

	@Column(name="puissanc")
	public String getPuissance() {
		return puissance;
	}

	public void setPuissance(String puissance) {
		this.puissance = puissance;
	}
}
