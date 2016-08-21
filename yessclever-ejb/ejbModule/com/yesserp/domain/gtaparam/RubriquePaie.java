package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: RubPaie
 *
 */
@Entity

public class RubriquePaie implements Serializable {

	
	private int idrp;
	private String coderp;
	private String typevalorisation;
	private int valhoraire;
	private int valnumerique;
	private List<Libelle> libelles;
	private List<Compteur> compteurs;
	private static final long serialVersionUID = 1L;

	public RubriquePaie() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdrp() {
		return this.idrp;
	}

	public void setIdrp(int idrp) {
		this.idrp = idrp;
	}   
	public String getCoderp() {
		return this.coderp;
	}

	public void setCoderp(String coderp) {
		this.coderp = coderp;
	}   
	public String getTypevalorisation() {
		return this.typevalorisation;
	}

	public void setTypevalorisation(String typevalorisation) {
		this.typevalorisation = typevalorisation;
	}   
	public int getValhoraire() {
		return this.valhoraire;
	}

	public void setValhoraire(int valhoraire) {
		this.valhoraire = valhoraire;
	}   
	public int getValnumerique() {
		return this.valnumerique;
	}

	public void setValnumerique(int valnumerique) {
		this.valnumerique = valnumerique;
	}
	@OneToMany(mappedBy="rubPaie")
	public List<Libelle> getLibelles() {
		return libelles;
	}
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	@ManyToMany
	@JoinTable(name="GTA_CMPTP_RUBP_UH01")
	public List<Compteur> getCompteurs() {
		return compteurs;
	}
	public void setCompteurs(List<Compteur> compteurs) {
		this.compteurs = compteurs;
	}
   
}
