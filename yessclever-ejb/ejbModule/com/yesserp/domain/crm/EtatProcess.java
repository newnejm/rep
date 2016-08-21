package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Entete
 *
 */
@Entity
@Table(name="crm_etpcuf01")
public class EtatProcess implements Serializable {

	   
	
	private Long id;
	private String nom;
	private String etat ;
	private Date date;
	
	
	private Compte compte;
	private Fournisseur fournisseur;
	private TypeProcess typeProcess;
    private Devis devis;
    private Bc bc;
    private Bl bl;
    private Facture facture;
    private Avoir avoir;

	
	
	
	
	
	
	private static final long serialVersionUID = 1L;

	public EtatProcess() {
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
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	@ManyToOne
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
	@ManyToOne
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	


	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	@ManyToOne
	public TypeProcess getTypeProcess() {
		return typeProcess;
	}

	public void setTypeProcess(TypeProcess typeProcess) {
		this.typeProcess = typeProcess;
	}

	@ManyToOne
	public Devis getDevis() {
		return devis;
	}

	public void setDevis(Devis devis) {
		this.devis = devis;
	}

	
	@ManyToOne
	public Bc getBc() {
		return bc;
	}

	public void setBc(Bc bc) {
		this.bc = bc;
	}

	
	@ManyToOne
	public Bl getBl() {
		return bl;
	}

	public void setBl(Bl bl) {
		this.bl = bl;
	}

	
	@ManyToOne
	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
		EtatProcess other = (EtatProcess) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	@ManyToOne
	public Avoir getAvoir() {
		return avoir;
	}

	public void setAvoir(Avoir avoir) {
		this.avoir = avoir;
	}
	
	
	
	
   
}
