package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.ga.Identite;

/**
 * Entity implementation class for Entity: PlanningTheorique
 * 
 */
@Entity
@Table(name = "gta_plthuh01")
public class PlanningTheorique implements Serializable {

	private int id;
	private Identite identite;
	private Date datePlanning;
	private static final long serialVersionUID = 1L;

	public PlanningTheorique() {
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

	@Temporal(TemporalType.DATE)
	public Date getDatePlanning() {
		return datePlanning;
	}

	public void setDatePlanning(Date datePlanning) {
		this.datePlanning = datePlanning;
	}

}
