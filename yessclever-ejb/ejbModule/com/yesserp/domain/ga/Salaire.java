package com.yesserp.domain.ga;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The persistent class for the ga_salauh01 database table.
 * 
 */
@Entity
@Table(name = "ga_salauh01")
@NamedQuery(name = "Salaire.findAll", query = "SELECT g FROM Salaire g")
public class Salaire implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private Date dateeffe;
	private Date datefin;
	private String montant;
	private String calendrierPaie;
	private String periode;
	private String rubrique;
	private Embauche embauche;

	public Salaire() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateeffe() {
		return this.dateeffe;
	}

	public void setDateeffe(Date dateeffe) {
		this.dateeffe = dateeffe;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	@ManyToOne
	@JoinColumn(name = "embauche")
	public Embauche getEmbauche() {
		return embauche;
	}

	public void setEmbauche(Embauche embauche) {
		this.embauche = embauche;
	}



	/**
	 * @return période: par mois/ par semaine...
	 */
	public String getPeriode() {
		return periode;
	}

	public void setPeriode(String periode) {
		this.periode = periode;
	}

	@Column(name = "calepaie")
	public String getCalendrierPaie() {
		return calendrierPaie;
	}

	public void setCalendrierPaie(String calendrierPaie) {
		this.calendrierPaie = calendrierPaie;
	}

	public String getRubrique() {
		return rubrique;
	}

	public void setRubrique(String rubrique) {
		this.rubrique = rubrique;
	}

	public String getMontant() {
		return montant;
	}

	public void setMontant(String montant) {
		this.montant = montant;
	}

}