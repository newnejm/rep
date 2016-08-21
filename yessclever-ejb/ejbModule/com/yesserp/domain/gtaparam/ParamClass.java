package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="GTA_PAR")
public class ParamClass implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPar;
	private String Formule;
	private String Condition;
	private String codeClasse;
	private FormuleCompteur formuleCompteur;

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdPar() {
		return idPar;
	}
	public void setIdPar(int idPar) {
		this.idPar = idPar;
	}
	public String getFormule() {
		return Formule;
	}
	public void setFormule(String formule) {
		Formule = formule;
	}
	public String getCondition() {
		return Condition;
	}

	public void setCondition(String condition) {
		Condition = condition;
	}

	public String getCodeClasse() {
		return codeClasse;
	}

	public void setCodeClasse(String codeClasse) {
		this.codeClasse = codeClasse;
	}

	@ManyToOne
	public FormuleCompteur getFormuleCompteur() {
		return formuleCompteur;
	}

	public void setFormuleCompteur(FormuleCompteur formuleCompteur) {
		this.formuleCompteur = formuleCompteur;
	}

}
