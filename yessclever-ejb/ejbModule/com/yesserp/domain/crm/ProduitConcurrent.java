package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Long;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ProduitConcurrent
 *
 */
@Entity
@Table(name="crm_prcrrf01")
public class ProduitConcurrent implements Serializable {

	
	private Long id;
	private String nomprodCon;
	private String nomCommercial;
	private Double partMarche;
	private Double prix;
	private String description;
	private String nomFournisseur;
	private String atout;
	private String inconvenient;
	
	private Concurrent concurrent;
	private TypeProduitConcurrent typeProduitConcurrent;
	
	private static final long serialVersionUID = 1L;

	public ProduitConcurrent() {
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
	public String getNomCommercial() {
		return this.nomCommercial;
	}

	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}   
	public Double getPrix() {
		return this.prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getNomFournisseur() {
		return this.nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}   
	public String getAtout() {
		return this.atout;
	}

	public void setAtout(String atout) {
		this.atout = atout;
	}   
	public String getInconvenient() {
		return this.inconvenient;
	}

	public void setInconvenient(String inconvenient) {
		this.inconvenient = inconvenient;
	}
	
	@ManyToOne
	public Concurrent getConcurrent() {
		return concurrent;
	}
	public void setConcurrent(Concurrent concurrent) {
		this.concurrent = concurrent;
	}
	
	
	@ManyToOne
	public TypeProduitConcurrent getTypeProduitConcurrent() {
		return typeProduitConcurrent;
	}
	public void setTypeProduitConcurrent(TypeProduitConcurrent typeProduitConcurrent) {
		this.typeProduitConcurrent = typeProduitConcurrent;
	}
	public Double getPartMarche() {
		return partMarche;
	}
	public void setPartMarche(Double partMarche) {
		this.partMarche = partMarche;
	}
	public String getNomprodCon() {
		return nomprodCon;
	}
	public void setNomprodCon(String nomprodCon) {
		this.nomprodCon = nomprodCon;
	}
	
   
}
