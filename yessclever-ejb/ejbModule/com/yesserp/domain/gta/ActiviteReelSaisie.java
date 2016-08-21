package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.ActivitePresence;

/**
 * Entity implementation class for Entity: ActiviteReelSaisie
 *
 */
@Entity
@Table(name = "GTA_TEST_ACT_SAISIE")
public class ActiviteReelSaisie implements Serializable {

	
	private long id;
	private Date date;
	private Date heuredeb;
	private Date heurefin;
	private Identite identite;
	private ActivitePresence activitePresence;
	private static final long serialVersionUID = 1L;

	public ActiviteReelSaisie() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	@Temporal(TemporalType.TIME)
	public Date getHeuredeb() {
		return heuredeb;
	}
	public void setHeuredeb(Date heuredeb) {
		this.heuredeb = heuredeb;
	}
	@Temporal(TemporalType.TIME)
	public Date getHeurefin() {
		return heurefin;
	}
	public void setHeurefin(Date heurefin) {
		this.heurefin = heurefin;
	}
	@ManyToOne
	public Identite getIdentite() {
		return identite;
	}
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	@ManyToOne
	public ActivitePresence getActivitePresence() {
		return activitePresence;
	}
	public void setActivitePresence(ActivitePresence activitePresence) {
		this.activitePresence = activitePresence;
	}
   
}
