package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: contact
 * 
 */
@Entity
@Table(name = "crm_cncfrh01")
public class ContactFournisseur implements Serializable {

	private Long id;
	private String nom;
	private String prenom;
	private String fonction;
	private String email;
	private long telephone;
	private long telmobile;
	private String resHierach;
	private String departement;
	private String service;
	private String poste;
	private String tags;

	private Fournisseur fournisseur;

	private List<CordonneeContactFournisseur> cordonneeContactFournisseurs;

	private static final long serialVersionUID = 1L;

	public long getTelmobile() {
		return telmobile;
	}

	public void setTelmobile(long telmobile) {
		this.telmobile = telmobile;
	}

	public String getResHierach() {
		return resHierach;
	}

	public void setResHierach(String resHierach) {
		this.resHierach = resHierach;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getPoste() {
		return poste;
	}

	public void setPoste(String poste) {
		this.poste = poste;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public ContactFournisseur() {
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
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFonction() {
		return this.fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelephone() {
		return this.telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	@ManyToOne
	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@OneToMany(mappedBy = "contacts", cascade = CascadeType.ALL)
	public List<CordonneeContactFournisseur> getCordonneeContactFournisseurs() {
		return cordonneeContactFournisseurs;
	}

	public void setCordonneeContactFournisseurs(List<CordonneeContactFournisseur> cordonneeContactFournisseurs) {
		this.cordonneeContactFournisseurs = cordonneeContactFournisseurs;
	}

	

}
