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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.ActiviteAbsence;
import com.yesserp.domain.gtaparam.Libelle;

/**
 * Entity implementation class for Entity: Absence
 * 
 */
@Entity
public class Absence implements Serializable {

	private int id;
	private ActiviteAbsence activiteAbsence;
	private Date dateDebut;
	private Date dateFin;
	private Identite identite;
	private boolean tansitionTranche;
	private boolean prolongation;
	private List<Tranche> tranches;
	private List<Libelle> libelles;
	private static final long serialVersionUID = 1L;

	public Absence() {
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

	@ManyToOne
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

	public boolean isTansitionTranche() {
		return tansitionTranche;
	}

	public void setTansitionTranche(boolean tansitionTranche) {
		this.tansitionTranche = tansitionTranche;
	}

	public boolean isProlongation() {
		return prolongation;
	}

	public void setProlongation(boolean prolongation) {
		this.prolongation = prolongation;
	}

	@ManyToOne
	public ActiviteAbsence getActiviteAbsence() {
		return activiteAbsence;
	}

	public void setActiviteAbsence(ActiviteAbsence activiteAbsence) {
		this.activiteAbsence = activiteAbsence;

	}

	@OneToMany(mappedBy = "absence", cascade = CascadeType.PERSIST)
	public List<Tranche> getTranches() {
		if (tranches == null)
			tranches = new ArrayList<Tranche>();
		return tranches;
	}

	public void setTranches(List<Tranche> tranches) {
		this.tranches = tranches;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	@Temporal(TemporalType.DATE)
	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	@OneToMany(mappedBy = "absence", cascade = CascadeType.PERSIST)
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
}
