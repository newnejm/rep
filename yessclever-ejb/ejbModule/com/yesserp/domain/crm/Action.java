package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.List;

import com.yesserp.domain.ga.Identite;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: activite
 * 
 */
@Entity
@Table(name = "crm_actrh01")
public class Action implements Serializable {

	private Long id;
	private String description;
	private Date dateDeb;
	private Date dateFin;
	private double budget;
	private double coutReel;
	private String note;
	private List<Identite> acteurs;
	private List<SuivieAction> suivis;
	private TypeAction typeAction;
	private Compagne compagne;

	private static final long serialVersionUID = 1L;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
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
		Action other = (Action) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

	public Action() {
		super();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateDeb() {
		return dateDeb;
	}

	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
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

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToMany
	public List<Identite> getActeurs() {
		return acteurs;
	}

	public void setActeurs(List<Identite> acteurs) {
		this.acteurs = acteurs;
	}

	@ManyToOne
	public TypeAction getTypeAction() {
		return typeAction;
	}

	public void setTypeAction(TypeAction typeAction) {
		this.typeAction = typeAction;
	}

	@OneToMany(mappedBy = "action", cascade = CascadeType.ALL)
	public List<SuivieAction> getSuivis() {
		return suivis;
	}

	public void setSuivis(List<SuivieAction> suivis) {
		this.suivis = suivis;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@ManyToOne
	public Compagne getCompagne() {
		return compagne;
	}

	public void setCompagne(Compagne compagne) {
		this.compagne = compagne;
	}

}
