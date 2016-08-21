package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.JourneeType;

/**
 * Entity implementation class for Entity: Exception
 *
 */
@Entity
@Table(name="GTA_excjour")
public class Exceptionjournee implements Serializable {

	
	private int id;
	private Date dateChangement;
	private Date dateJournee;
	private String journeeTypeavant;
	private JourneeType journeeTypeApres;
	private Identite identite;
	private static final long serialVersionUID = 1L;

	public Exceptionjournee() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public Date getDateChangement() {
		return this.dateChangement;
	}

	public void setDateChangement(Date dateChangement) {
		this.dateChangement = dateChangement;
	}
	
	@ManyToOne
	public JourneeType getJourneeTypeApres() {
		return journeeTypeApres;
	}
	public void setJourneeTypeApres(JourneeType journeeTypeApres) {
		this.journeeTypeApres = journeeTypeApres;
	}
	public String getJourneeTypeavant() {
		return journeeTypeavant;
	}
	public void setJourneeTypeavant(String journeeTypeavant) {
		this.journeeTypeavant = journeeTypeavant;
	}
	@ManyToOne
	public Identite getIdentite() {
		return identite;
	}
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	public Date getDateJournee() {
		return dateJournee;
	}
	public void setDateJournee(Date dateJournee) {
		this.dateJournee = dateJournee;
	}
   
}
