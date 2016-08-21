package com.yesserp.domain.crm;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Compte
 * 
 */
@Entity
@Table(name = "crm_cmptrf01")
public class Compte implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String numcompt;
	private String nomcompt;
	private String matfiscl;
	private String siteweb;
	private String description;
	private long tel1;
	private long tel2;
	private long tel3;
	private long fax;
	private double chiffAff;
	private String secteur;
	private byte[] logo;
	private String tags;

	private TypeCompte compte;
	private List<ContactCompte> contacts;
	private List<EtatProcess> etatVentes;
	private List<Opportunite> opportunites;
	private List<CordonneeCompte> cordonneeComptes;
	private List<TravailInterne> travailInternes;
	private List<TravailExterne> travailExternes;

	private List<DocumentCompte> documentComptes;
	private List<Service> services;
	private List<Compagne> compagnes;

   
    private List<TauxCompte> tauxComptes;

	public String getSiteweb() {
		return siteweb;
	}

	public void setSiteweb(String siteweb) {
		this.siteweb = siteweb;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public long getFax() {
		return fax;
	}

	public void setFax(long fax) {
		this.fax = fax;
	}

	public String getSecteur() {
		return secteur;
	}

	public void setSecteur(String secteur) {
		this.secteur = secteur;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Compte() {
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

	public String getNumcompt() {
		return numcompt;
	}

	public void setNumcompt(String numcompt) {
		this.numcompt = numcompt;
	}

	public String getNomcompt() {
		return nomcompt;
	}

	public void setNomcompt(String nomcompt) {
		this.nomcompt = nomcompt;
	}

	public String getMatfiscl() {
		return matfiscl;
	}

	public void setMatfiscl(String matfiscl) {
		this.matfiscl = matfiscl;
	}

	@ManyToOne
	public TypeCompte getCompte() {
		return compte;
	}

	public void setCompte(TypeCompte compte) {
		this.compte = compte;
	}

	@OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
	public List<ContactCompte> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactCompte> contacts) {
		this.contacts = contacts;
	}




	@OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
	public List<Opportunite> getOpportunites() {
		return opportunites;
	}

	public void setOpportunites(List<Opportunite> opportunites) {
		this.opportunites = opportunites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomcompt == null) ? 0 : nomcompt.hashCode());
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
		Compte other = (Compte) obj;
		if (nomcompt == null) {
			if (other.nomcompt != null)
				return false;
		} else if (!nomcompt.equals(other.nomcompt))
			return false;
		return true;
	}

	@OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
	public List<CordonneeCompte> getCordonneeComptes() {
		return cordonneeComptes;
	}

	public void setCordonneeComptes(List<CordonneeCompte> cordonneeComptes) {
		this.cordonneeComptes = cordonneeComptes;
	}

	@OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
	public List<TravailInterne> getTravailInternes() {
		return travailInternes;
	}

	public void setTravailInternes(List<TravailInterne> travailInternes) {
		this.travailInternes = travailInternes;
	}

	@OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
	public List<TravailExterne> getTravailExternes() {
		return travailExternes;
	}

	public void setTravailExternes(List<TravailExterne> travailExternes) {
		this.travailExternes = travailExternes;
	}

	@OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
	public List<DocumentCompte> getDocumentComptes() {
		return documentComptes;
	}

	public void setDocumentComptes(List<DocumentCompte> documentComptes) {
		this.documentComptes = documentComptes;
	}



	@OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)




	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@ManyToMany(mappedBy = "membres")
	public List<Compagne> getCompagnes() {
		return compagnes;
	}


	public void setCompagnes(List<Compagne> compagnes) {
		this.compagnes = compagnes;
	}



	
	@OneToMany(mappedBy="compte",cascade=CascadeType.ALL)
	public List<TauxCompte> getTauxComptes() {
		return tauxComptes;
	}
	public void setTauxComptes(List<TauxCompte> tauxComptes) {
		this.tauxComptes = tauxComptes;
	}
	public double getChiffAff() {
		return chiffAff;
	}
	public void setChiffAff(double chiffAff) {
		this.chiffAff = chiffAff;
	}
	@OneToMany(mappedBy = "compte", cascade = CascadeType.ALL)
	public List<EtatProcess> getEtatVentes() {
		return etatVentes;
	}

	public void setEtatVentes(List<EtatProcess> etatVentes) {
		this.etatVentes = etatVentes;
	}
}
