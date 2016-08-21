package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.TerminalMobile;

/**
 * Entity implementation class for Entity: Occurence
 * 
 */
@Entity
@Table(name = "gta_donnegta")
public class ContratGta implements Serializable {

	private int id;
	private boolean pointage;
	private Date dateeffe;
	private Date datefin;
	private Date dateEffet2 ;
	private Date dateFin2;
	private String natureHeure;
	private boolean gta;
	private int index ;
	private Identite identite ;
	
	private List<TerminalMobile> terminalMobiles ;
	private static final long serialVersionUID = 1L;
	public ContratGta() {
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
	public boolean isPointage() {
		return pointage;
	}
	public void setPointage(boolean pointage) {
		this.pointage = pointage;
	}

	
	

	public String getNatureHeure() {
		return natureHeure;
	}

	public void setNatureHeure(String natureHeure) {
		this.natureHeure = natureHeure;
	}

	




	public boolean isGta() {
		return gta;
	}

	public void setGta(boolean gta) {
		this.gta = gta;
	}

	
	
	@Temporal(TemporalType.DATE)
	public Date getDateeffe() {
		return dateeffe;
	}
	public void setDateeffe(Date dateeffe) {
		this.dateeffe = dateeffe;
	}
	@Temporal(TemporalType.DATE)
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	@OneToMany (mappedBy="contratGta", cascade= CascadeType.ALL,fetch = FetchType.EAGER)
	public List<TerminalMobile> getTerminalMobiles() {
		return terminalMobiles;
	}
	public void setTerminalMobiles(List<TerminalMobile> terminalMobiles) {
		this.terminalMobiles = terminalMobiles;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@ManyToOne
	@JoinColumn(name="contratgta")
	public Identite getIdentite() {
		return identite;
	}
	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateEffet2() {
		return dateEffet2;
	}
	public void setDateEffet2(Date dateEffet2) {
		this.dateEffet2 = dateEffet2;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateFin2() {
		return dateFin2;
	}
	public void setDateFin2(Date dateFin2) {
		this.dateFin2 = dateFin2;
	}
	@Override
	public String toString() {
		return "ContratGta [id=" + id + ", pointage=" + pointage
				+ ", dateeffe=" + dateeffe + ", datefin=" + datefin
				+ ", dateEffet2=" + dateEffet2 + ", dateFin2=" + dateFin2
				+ ", natureHeure=" + natureHeure + ", gta=" + gta + ", index="
				+ index + ", identite=" + identite + ", terminalMobiles="
				+ terminalMobiles + "]";
	}
	
	
	
}
