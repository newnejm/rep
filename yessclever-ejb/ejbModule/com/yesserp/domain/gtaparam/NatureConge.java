package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: NatureConge
 *
 */
@Entity
@Table(name = "GTA_NC_")
public class NatureConge implements Serializable {

	
	private int idnc;
	private String libelle;
	private AbsenceTypeConge absenceTypeConge;
	private static final long serialVersionUID = 1L;

	public NatureConge() {
		super();
	}   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdnc() {
		return this.idnc;
	}

	public void setIdnc(int idnc) {
		this.idnc = idnc;
	}   
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@ManyToOne
	public AbsenceTypeConge getAbsenceTypeConge() {
		return absenceTypeConge;
	}
	public void setAbsenceTypeConge(AbsenceTypeConge absenceTypeConge) {
		this.absenceTypeConge = absenceTypeConge;
	}
   
}
