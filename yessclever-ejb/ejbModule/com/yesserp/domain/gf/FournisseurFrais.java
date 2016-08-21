package com.yesserp.domain.gf;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Fournisseur
 * 
 */
@Entity
@Table(name = "gf_fourrh01")
public class FournisseurFrais implements Serializable {

	private Long id;
	private String nom;
	private String adresse;
	private String telephone;
	private String fax;
	private String mail;
	private List<FourFrais> fourFrais;
	private static final long serialVersionUID = 1L;

	public FournisseurFrais() {
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

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@OneToMany(mappedBy = "fournisseurFrais")
	public List<FourFrais> getFourFrais() {
		return fourFrais;
	}

	public void setFourFrais(List<FourFrais> fourFrais) {
		this.fourFrais = fourFrais;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
