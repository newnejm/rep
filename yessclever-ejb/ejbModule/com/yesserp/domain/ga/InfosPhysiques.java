package com.yesserp.domain.ga;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The persistent class for the ga_infouf02 database table.
 * 
 */
@Entity
@Table(name = "ga_infouf02")
@NamedQuery(name = "InfosPhysiques.findAll", query = "SELECT g FROM InfosPhysiques g")
public class InfosPhysiques implements Serializable {
	private static final long serialVersionUID = 1L;
	private Long id;
	private double hauteur;
	private double poids;
	private double pointure;
	private String tailleChemise;
	private String tailleVeste;
	private String tailleGants;
	private String taillePantalon;
	private String tailleCasque;
	private String tailleRobe;

	private Identite identite;

	public InfosPhysiques() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPoids() {
		return this.poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getPointure() {
		return this.pointure;
	}

	public void setPointure(double pointure) {
		this.pointure = pointure;
	}

	public double getHauteur() {
		return hauteur;
	}

	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
	}

	public String getTailleChemise() {
		return tailleChemise;
	}

	public void setTailleChemise(String tailleChemise) {
		this.tailleChemise = tailleChemise;
	}

	public String getTailleVeste() {
		return tailleVeste;
	}

	public void setTailleVeste(String tailleVeste) {
		this.tailleVeste = tailleVeste;
	}

	public String getTailleGants() {
		return tailleGants;
	}

	public void setTailleGants(String tailleGants) {
		this.tailleGants = tailleGants;
	}

	public String getTaillePantalon() {
		return taillePantalon;
	}

	public void setTaillePantalon(String taillePantalon) {
		this.taillePantalon = taillePantalon;
	}

	public String getTailleCasque() {
		return tailleCasque;
	}

	public void setTailleCasque(String tailleCasque) {
		this.tailleCasque = tailleCasque;
	}

	public String getTailleRobe() {
		return tailleRobe;
	}

	public void setTailleRobe(String tailleRobe) {
		this.tailleRobe = tailleRobe;
	}

	@OneToOne
	@JoinColumn(name = "dossempl")
	public Identite getIdentite() {
		return this.identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

}