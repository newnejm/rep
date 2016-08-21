package com.yesserp.domain.wkf;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "pgw_demande")
@NamedQuery(name = "Demande.findAll", query = "SELECT a FROM Demande a")
public class Demande implements Serializable {

	   
	
	private Long id;
	private String motif;
	private Date date_debut;
	private Date date_fin;
	private String heure_debut;
	private String heure_fin;
	private String duree;
	private String quantite;
	private Double montant;
	private String texte;
	
	static final long serialVersionUID = 1L;

	public Demande() {
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

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	@Temporal(TemporalType.DATE)
	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	@Temporal(TemporalType.DATE)
	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public String getHeure_debut() {
		return heure_debut;
	}

	public void setHeure_debut(String heure_debut) {
		this.heure_debut = heure_debut;
	}

	public String getHeure_fin() {
		return heure_fin;
	}

	public void setHeure_fin(String heure_fin) {
		this.heure_fin = heure_fin;
	}

	public String getDuree() {
		return duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

	
	
	
   
}
