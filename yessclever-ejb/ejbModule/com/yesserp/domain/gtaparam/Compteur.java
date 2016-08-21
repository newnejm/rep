package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: Compteur
 * 
 */
@Entity
@Table(name = "GTA_CMPTP_UH01")
public class Compteur implements Serializable {

	private int idc;
	private String codec;
	private List<Libelle> libelles;
	private String typeop;
	private String typeCmp;
	private String operation;
	private String methodeDeCalcul;
	private String typeDeCalcul;
	private int valinit;
	private int valmin;
	private int valmax;
	private int typevaleur;
	private int coefficient;
	private int numMoisDeDebut;
	private Date dateDebutPeroide;
	private Date dateFinPeriode;
	private List<RubriquePaie> rubPaies;
	private List<Anomalie> anomalies;
	private List<ValeurCompteur> valeurCompteurs;
	private List<GroupeCompteur> groupeCompteurs;
	private List<FormuleCompteur> formuleCompteurs;
	// private List<Compteur> parent;
	private List<FilsCompteur> fils;
	private CodeGTA codeGTA ;

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "compteur")
	public List<Anomalie> getAnomalies() {
		return anomalies;
	}

	public void setAnomalies(List<Anomalie> anomalies) {
		this.anomalies = anomalies;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Compteur() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdc() {
		return this.idc;
	}

	public void setIdc(int idc) {
		this.idc = idc;
	}

	public String getCodec() {
		return this.codec;
	}

	public void setCodec(String codec) {
		this.codec = codec;
	}

	public String getTypeop() {
		return this.typeop;
	}

	public void setTypeop(String typeop) {
		this.typeop = typeop;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public int getValinit() {
		return this.valinit;
	}

	public void setValinit(int valinit) {
		this.valinit = valinit;
	}

	public int getValmin() {
		return this.valmin;
	}

	public void setValmin(int valmin) {
		this.valmin = valmin;
	}

	public int getValmax() {
		return this.valmax;
	}

	public void setValmax(int valmax) {
		this.valmax = valmax;
	}

	@OneToMany(mappedBy = "compteur")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codec == null) ? 0 : codec.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compteur other = (Compteur) obj;
		if (codec == null) {
			if (other.codec != null)
				return false;
		} else if (!codec.equals(other.codec))
			return false;
		return true;
	}

	@ManyToMany(mappedBy = "compteurs")
	public List<RubriquePaie> getRubPaies() {
		return rubPaies;
	}

	public void setRubPaies(List<RubriquePaie> rubPaies) {
		this.rubPaies = rubPaies;
	}

	public int getTypevaleur() {
		return typevaleur;
	}

	public void setTypevaleur(int typevaleur) {
		this.typevaleur = typevaleur;
	}

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	@OneToMany(mappedBy = "compteur")
	public List<ValeurCompteur> getValeurCompteurs() {
		return valeurCompteurs;
	}

	public void setValeurCompteurs(List<ValeurCompteur> valeurCompteurs) {
		this.valeurCompteurs = valeurCompteurs;
	}

	@OneToMany(mappedBy = "compteur", cascade = CascadeType.ALL)
	public List<FormuleCompteur> getFormuleCompteurs() {
		return formuleCompteurs;
	}

	public void setFormuleCompteurs(List<FormuleCompteur> formuleCompteurs) {
		this.formuleCompteurs = formuleCompteurs;
	}

	@ManyToMany(mappedBy = "compteurs")
	public List<GroupeCompteur> getGroupeCompteurs() {
		return groupeCompteurs;
	}

	public void setGroupeCompteurs(List<GroupeCompteur> groupeCompteurs) {
		this.groupeCompteurs = groupeCompteurs;
	}

	// @OneToMany(mappedBy="compteur")
	// public List<Compteur> getParent() {
	// return parent;
	// }
	//
	// public void setParent(List<Compteur> parent) {
	// this.parent = parent;
	// }

	public String getTypeCmp() {
		return typeCmp;
	}

	public void setTypeCmp(String typeCmp) {
		this.typeCmp = typeCmp;
	}

	public int getNumMoisDeDebut() {
		return numMoisDeDebut;
	}

	public void setNumMoisDeDebut(int numMoisDeDebut) {
		this.numMoisDeDebut = numMoisDeDebut;
	}

	public Date getDateDebutPeroide() {
		return dateDebutPeroide;
	}

	public void setDateDebutPeroide(Date dateDebutPeroide) {
		this.dateDebutPeroide = dateDebutPeroide;
	}

	public Date getDateFinPeriode() {
		return dateFinPeriode;
	}

	public void setDateFinPeriode(Date dateFinPeriode) {
		this.dateFinPeriode = dateFinPeriode;
	}

	public String getMethodeDeCalcul() {
		return methodeDeCalcul;
	}

	public void setMethodeDeCalcul(String methodeDeCalcul) {
		this.methodeDeCalcul = methodeDeCalcul;
	}

	public String getTypeDeCalcul() {
		return typeDeCalcul;
	}

	public void setTypeDeCalcul(String typeDeCalcul) {
		this.typeDeCalcul = typeDeCalcul;
	}

	@OneToMany(mappedBy = "compteur", cascade = { CascadeType.PERSIST,
			CascadeType.MERGE })
	public List<FilsCompteur> getFils() {
		return fils;
	}

	public void setFils(List<FilsCompteur> fils) {
		this.fils = fils;
	}
	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}



}
