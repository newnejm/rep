package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: GestionConge
 *
 */
@Entity
@Table(name = "GTA_GCong_")
public class GestionConge implements Serializable {

	
	private int idgc;
	private Boolean cp;
	private Unite unitedecompte;
	private Compteur compteuracquisition;
	private Compteur rubriqueN_1;
	private Compteur rubriqueN;

	private static final long serialVersionUID = 1L;

	public GestionConge() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdgc() {
		return this.idgc;
	}

	public void setIdgc(int idgc) {
		this.idgc = idgc;
	}   


	public Boolean getCp() {
		return cp;
	}
	public void setCp(Boolean cp) {
		this.cp = cp;
	}
	public Unite getUnitedecompte() {
		return unitedecompte;
	}
	public void setUnitedecompte(Unite unitedecompte) {
		this.unitedecompte = unitedecompte;
	}
	public Compteur getCompteuracquisition() {
		return compteuracquisition;
	}
	public void setCompteuracquisition(Compteur compteuracquisition) {
		this.compteuracquisition = compteuracquisition;
	}
	public Compteur getRubriqueN_1() {
		return rubriqueN_1;
	}
	public void setRubriqueN_1(Compteur rubriqueN_1) {
		this.rubriqueN_1 = rubriqueN_1;
	}
	public Compteur getRubriqueN() {
		return rubriqueN;
	}
	public void setRubriqueN(Compteur rubriqueN) {
		this.rubriqueN = rubriqueN;
	}
	
	
   
}
