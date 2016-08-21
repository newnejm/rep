package com.yesserp.domain.gta;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yesserp.domain.gtaparam.JourFerier;

/**
 * Entity implementation class for Entity: Calendrier
 * 
 */
@Entity
@Table(name = "gta_calendrier")
public class Calendrier implements Serializable {

	private int id;

	// attribute added by omar le 23/08
	private String code;
	private Date dateEffet;
	private List<Jourferier> ljferier = new ArrayList<Jourferier>();
	// fin attribute added by omar le 23/08

	private Date dateJourFerier;
	private String nomJourFerier;
	private String typeJour;
	private List<CodeCalendrier> calendriers;

	private static final long serialVersionUID = 1L;

	public Calendrier() {
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

	public Date getDateEffet() {
		return dateEffet;
	}

	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}

	public Date getDateJourFerier() {
		return dateJourFerier;
	}

	public void setDateJourFerier(Date dateJourFerier) {
		this.dateJourFerier = dateJourFerier;
	}

	public String getNomJourFerier() {
		return nomJourFerier;
	}

	public void setNomJourFerier(String nomJourFerier) {
		this.nomJourFerier = nomJourFerier;
	}

	public String getTypeJour() {
		return typeJour;
	}

	public void setTypeJour(String typeJour) {
		this.typeJour = typeJour;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomJourFerier == null) ? 0 : nomJourFerier.hashCode());
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
		Calendrier other = (Calendrier) obj;
		if (nomJourFerier == null) {
			if (other.nomJourFerier != null)
				return false;
		} else if (!nomJourFerier.equals(other.nomJourFerier))
			return false;
		return true;
	}

	@ManyToMany(mappedBy = "calendriers", cascade = CascadeType.ALL)
	public List<CodeCalendrier> getCalendriers() {
		return calendriers;
	}

	public void setCalendriers(List<CodeCalendrier> calendriers) {
		this.calendriers = calendriers;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(mappedBy = "calendrier", cascade = CascadeType.REMOVE)
	public List<Jourferier> getLjferier() {
		return ljferier;
	}

	public void setLjferier(List<Jourferier> ljferier) {
		this.ljferier = ljferier;
	}

}
