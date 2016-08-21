package com.yesserp.domain.gtaparam;

import java.io.Serializable;
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
import javax.persistence.PersistenceContextType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "GTA_CMPTP_FORM")
public class FormuleCompteur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idFormule;
	private Date dateEffet;
	@SuppressWarnings("deprecation")
	private Date dateFin = new Date(199, 11, 20);
	private Compteur compteur;
	private List<ParamClass> paramClasses;
	private List<Filtre> filters;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdFormule() {
		return idFormule;
	}

	public void setIdFormule(int idFormule) {
		this.idFormule = idFormule;
	}

	public Date getDateEffet() {
		return dateEffet;
	}

	public void setDateEffet(Date dateEffet) {
		this.dateEffet = dateEffet;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@ManyToOne
	public Compteur getCompteur() {
		return compteur;
	}

	public void setCompteur(Compteur compteur) {
		this.compteur = compteur;
	}

	@ManyToMany
	public List<Filtre> getFilters() {
		return filters;
	}

	public void setFilters(List<Filtre> filters) {
		this.filters = filters;
	}

	@OneToMany(mappedBy = "formuleCompteur" ,cascade=CascadeType.ALL)
	public List<ParamClass> getParamClasses() {
		return paramClasses;
	}

	public void setParamClasses(List<ParamClass> paramClasses) {
		this.paramClasses = paramClasses;
	}

}
