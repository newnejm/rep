package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: DateJournees
 * 
 */
@Entity
@Table(name="gta_dateCalcul")
public class DateCalculGta implements Serializable {

	private int id;
	private Date dateJourCalcul;
	private Date dateDebutCalcul;
	private Date dateFinCalcul;
	private List<TypeCalucle> typeCalucles;
	private static final long serialVersionUID = 1L;

	public DateCalculGta() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateJourCalcul() {
		return dateJourCalcul;
	}

	public void setDateJourCalcul(Date dateJourCalcul) {
		this.dateJourCalcul = dateJourCalcul;
	}

	public Date getDateDebutCalcul() {
		return dateDebutCalcul;
	}

	public void setDateDebutCalcul(Date dateDebutCalcul) {
		this.dateDebutCalcul = dateDebutCalcul;
	}

	public Date getDateFinCalcul() {
		return dateFinCalcul;
	}

	public void setDateFinCalcul(Date dateFinCalcul) {
		this.dateFinCalcul = dateFinCalcul;
	}

	@ManyToMany
	public List<TypeCalucle> getTypeCalucles() {
		return typeCalucles;
	}

	public void setTypeCalucles(List<TypeCalucle> typeCalucles) {
		this.typeCalucles = typeCalucles;
	}

}
