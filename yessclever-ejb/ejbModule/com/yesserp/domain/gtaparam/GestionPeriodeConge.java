package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: GestionPeriodeConge
 *
 */
@Entity
@Table(name = "GTA_GPC_")
public class GestionPeriodeConge implements Serializable {

	
	private int idgpc;
	private Date dateeffet;
	private Date datefin;
	private int moisdebutA;
	private int jourdebutA;
	private int moisfinA;
	private int jourfinA;
	private int moisdebutC;
	private int jourdebutC;
	private int moisfinC;
	private int jourfinC;
	private ActiviteAbsence activiteAbsence;
	
	private static final long serialVersionUID = 1L;

	public GestionPeriodeConge() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdgpc() {
		return this.idgpc;
	}

	public void setIdgpc(int idgpc) {
		this.idgpc = idgpc;
	}
	
	
	public Date getDateeffet() {
		return dateeffet;
	}
	public void setDateeffet(Date dateeffet) {
		this.dateeffet = dateeffet;
	}
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}


	public int getMoisdebutA() {
		return moisdebutA;
	}
	public void setMoisdebutA(int moisdebutA) {
		this.moisdebutA = moisdebutA;
	}
	public int getJourdebutA() {
		return jourdebutA;
	}
	public void setJourdebutA(int jourdebutA) {
		this.jourdebutA = jourdebutA;
	}
	public int getMoisfinA() {
		return moisfinA;
	}
	public void setMoisfinA(int moisfinA) {
		this.moisfinA = moisfinA;
	}
	public int getJourfinA() {
		return jourfinA;
	}
	public void setJourfinA(int jourfinA) {
		this.jourfinA = jourfinA;
	}
	public int getMoisdebutC() {
		return moisdebutC;
	}
	public void setMoisdebutC(int moisdebutC) {
		this.moisdebutC = moisdebutC;
	}
	public int getJourdebutC() {
		return jourdebutC;
	}
	public void setJourdebutC(int jourdebutC) {
		this.jourdebutC = jourdebutC;
	}
	public int getMoisfinC() {
		return moisfinC;
	}
	public void setMoisfinC(int moisfinC) {
		this.moisfinC = moisfinC;
	}
	public int getJourfinC() {
		return jourfinC;
	}
	public void setJourfinC(int jourfinC) {
		this.jourfinC = jourfinC;
	}
	@ManyToOne
	public ActiviteAbsence getActiviteAbsence() {
		return activiteAbsence;
	}
	public void setActiviteAbsence(ActiviteAbsence activiteAbsence) {
		this.activiteAbsence = activiteAbsence;
	}
	

	

   
}
