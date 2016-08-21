package com.yesserp.domain.access;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Company
 *
 */
@Entity

public class Company implements Serializable {

	
	private int id_company;
	private String name;
	private String reseauSocial;
	private String adresse;
	private List<Utilisateur> utilisateurs;
	private static final long serialVersionUID = 1L;

	public Company() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId_company() {
		return this.id_company;
	}

	public void setId_company(int id_company) {
		this.id_company = id_company;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy="company", cascade = CascadeType.PERSIST)
	public List<Utilisateur> getUtilisateurs() {
		if (utilisateurs==null) {
			utilisateurs= new ArrayList<Utilisateur>();
		}
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public void addUtilisateur(Utilisateur utilisateur)
	{
		utilisateur.setCompany(this);
		this.getUtilisateurs().add(utilisateur);
	}
	public String getReseauSocial() {
		return reseauSocial;
	}
	public void setReseauSocial(String reseauSocial) {
		this.reseauSocial = reseauSocial;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
