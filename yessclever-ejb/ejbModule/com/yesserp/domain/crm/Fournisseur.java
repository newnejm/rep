package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Fournisseur
 * 
 */
@Entity
@Table(name = "crm_frnsrh01")
public class Fournisseur implements Serializable {

	private Long id;
	private String nom;
	private String matfiscal;
	private long tel1;
	private long tel2;
	private long tel3;
	private long fax;
	private String tags;
	private byte[] logo;

	private List<CordonneeFournisseur> cordonneeFournisseurs;
	private List<EtatProcess> etatVente;
	private List<DocumentFournisseur> documentFournisseurs;
	private List<ContactFournisseur> contactFournisseurs;

	private static final long serialVersionUID = 1L;

	public long getTel1() {
		return tel1;
	}

	public void setTel1(long tel1) {
		this.tel1 = tel1;
	}

	public long getTel2() {
		return tel2;
	}

	public void setTel2(long tel2) {
		this.tel2 = tel2;
	}

	public long getTel3() {
		return tel3;
	}

	public void setTel3(long tel3) {
		this.tel3 = tel3;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public long getFax() {
		return fax;
	}

	public void setFax(long fax) {
		this.fax = fax;
	}

	public Fournisseur() {
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

	

	public String getMatfiscal() {
		return this.matfiscal;
	}

	public void setMatfiscal(String matfiscal) {
		this.matfiscal = matfiscal;
	}

	@OneToMany(mappedBy = "fournisseur", cascade = CascadeType.ALL)
	public List<EtatProcess> getetatVente() {
		return etatVente;
	}

	public void setEtatVente(List<EtatProcess> entete) {
		this.etatVente = entete;
	}

	@OneToMany(mappedBy = "fournisseurs", cascade = CascadeType.ALL)
	public List<CordonneeFournisseur> getCordonneeFournisseurs() {
		return cordonneeFournisseurs;
	}

	public void setCordonneeFournisseurs(
			List<CordonneeFournisseur> cordonneeFournisseurs) {
		this.cordonneeFournisseurs = cordonneeFournisseurs;
	}

	@OneToMany(mappedBy="fournisseur" ,cascade=CascadeType.ALL)
	public List<DocumentFournisseur> getDocumentFournisseurs() {
		return documentFournisseurs;
	}

	public void setDocumentFournisseurs(List<DocumentFournisseur> documentFournisseurs) {
		this.documentFournisseurs = documentFournisseurs;
	}
	
	@OneToMany(mappedBy="fournisseur" ,cascade=CascadeType.ALL)
	public List<ContactFournisseur> getContactFournisseurs() {
		return contactFournisseurs;
	}

	public void setContactFournisseurs(List<ContactFournisseur> contactFournisseurs) {
		this.contactFournisseurs = contactFournisseurs;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fournisseur other = (Fournisseur) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}


	
	
}
