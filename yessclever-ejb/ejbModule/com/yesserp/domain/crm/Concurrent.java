package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Concurrent
 *
 */
@Entity
@Table(name="crm_cncrrf01")
public class Concurrent implements Serializable {
	private static final long serialVersionUID = 1L;

	
	
	private Long id;
	private String nom;
	private String matfiscl;
	private String siteweb;
	private String description;
	private long tel1;
	private long tel2;
	private long tel3;
	private long fax;
	private String secteur;
	
	private Produit produit;
	private List<ProduitConcurrent> produitConcurrents;
	
	private List<CordonneeConcurrent> cordonneeConcurents;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nomcompt) {
		this.nom = nomcompt;
	}
	public String getMatfiscl() {
		return matfiscl;
	}
	public void setMatfiscl(String matfiscl) {
		this.matfiscl = matfiscl;
	}
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
	
	
	@ManyToOne
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	
	@OneToMany(mappedBy="concurrent",cascade=CascadeType.ALL)
	public List<CordonneeConcurrent> getCordonneeConcurents() {
		return cordonneeConcurents;
	}
	public void setCordonneeConcurents(List<CordonneeConcurrent> cordonneeConcurents) {
		this.cordonneeConcurents = cordonneeConcurents;
	}
	
	@OneToMany(mappedBy="concurrent",cascade=CascadeType.ALL)
	public List<ProduitConcurrent> getProduitConcurrents() {
		return produitConcurrents;
	}
	public void setProduitConcurrents(List<ProduitConcurrent> produitConcurrents) {
		this.produitConcurrents = produitConcurrents;
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
		Concurrent other = (Concurrent) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	
   
}
