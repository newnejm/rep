package com.yesserp.domain.gs;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.yesserp.type.gs.TypeMagasin;

/**
 * Entity implementation class for Entity: Magasin
 * 
 */
@Entity
@Table(name = "gs_magasin")
public class Magasin implements Serializable {

	private int id;
	private String nom;
	private String adresse;
	private TypeMagasin type;
	private String description;

	private List<Lot> lot;

	private static final long serialVersionUID = 1L;

	public Magasin() {
		super();
	}

	public Magasin(String nom, String adresse, TypeMagasin type,
			String description) {
		this.nom = nom;
		this.adresse = adresse;
		this.type = type;
		this.description = description;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(unique = true)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public TypeMagasin getType() {
		return type;
	}

	public void setType(TypeMagasin type) {
		this.type = type;
	}

	@OneToMany(mappedBy = "magasin", cascade = CascadeType.ALL)
	public List<Lot> getLot() {
		return lot;
	}

	public void setLot(List<Lot> lot) {
		this.lot = lot;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
