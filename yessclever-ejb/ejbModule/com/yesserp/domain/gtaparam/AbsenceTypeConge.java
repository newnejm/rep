package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: AbscenceTypeConge
 *
 */
@Entity


public class AbsenceTypeConge implements Serializable {

	
	private int idatc;
	private String droitacquisition;
	private Date gestionheure;
	private ActiviteAbsence activiteAbsence;
	private List<NatureConge>natureConges;
	private static final long serialVersionUID = 1L;

	public AbsenceTypeConge() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdatc() {
		return this.idatc;
	}

	public void setIdatc(int idatc) {
		this.idatc = idatc;
	}   
	public String getDroitacquisition() {
		return this.droitacquisition;
	}

	public void setDroitacquisition(String droitacquisition) {
		this.droitacquisition = droitacquisition;
	}   
	public Date getGestionheure() {
		return this.gestionheure;
	}

	public void setGestionheure(Date gestionheure) {
		this.gestionheure = gestionheure;
	}
	@ManyToOne
	public ActiviteAbsence getActiviteAbsence() {
		return activiteAbsence;
	}
	public void setActiviteAbsence(ActiviteAbsence activiteAbsence) {
		this.activiteAbsence = activiteAbsence;
	}
	@OneToMany(mappedBy="absenceTypeConge")
	public List<NatureConge> getNatureConges() {
		return natureConges;
	}
	public void setNatureConges(List<NatureConge> natureConges) {
		this.natureConges = natureConges;
	}

   
}
