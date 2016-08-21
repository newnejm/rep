package com.yesserp.domain.crm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity implementation class for Entity: Compagne
 * 
 */
@Entity
@Table(name = "crm_cpgnrh01")
public class Compagne implements Serializable {

	private Long id;
	private String nom;
	private String description;
	private Date datedeb;
	private Date datefin;
	private double budget;
	private double coutReel;
	private Marketing marketing;
	private StatusCompagne status;
	private List<Produit> produits;
	private TypeCompagne typeCompagne;
	private List<Opportunite> opportunites;
	private List<Compte> membres;
	private List<Action> actions;

	private static final long serialVersionUID = 1L;

	public Compagne() {
		super();
		this.actions = new ArrayList<Action>();
		this.produits = new ArrayList<Produit>();
		this.membres = new ArrayList<Compte>();
	}

	@ManyToOne
	public StatusCompagne getStatus() {
		return status;
	}

	public void setStatus(StatusCompagne status) {
		this.status = status;
	}

	@ManyToOne
	public Marketing getMarketing() {
		return marketing;
	}

	public void setMarketing(Marketing marketing) {
		this.marketing = marketing;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@OneToMany(mappedBy = "compagne", cascade = CascadeType.ALL)
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
		Compagne other = (Compagne) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public double getCoutReel() {
		return coutReel;
	}

	public void setCoutReel(double coutReel) {
		this.coutReel = coutReel;
	}

	@ManyToMany
	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@ManyToMany
	public List<Compte> getMembres() {
		return membres;
	}

	public void setMembres(List<Compte> membres) {
		this.membres = membres;
	}

	@ManyToOne
	public TypeCompagne getTypeCompagne() {
		return typeCompagne;
	}

	public void setTypeCompagne(TypeCompagne typeCompagne) {
		this.typeCompagne = typeCompagne;
	}

	@OneToMany(mappedBy = "compagne", cascade = CascadeType.ALL)
	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

}
