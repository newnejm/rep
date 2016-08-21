package com.yesserp.domain.gs;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Sous_Categorie
 * 
 */
@Entity
@Table(name = "gs_s_cat")
public class Sous_Categorie implements Serializable {

	private int id;
	private String nom;

	private List<Prod> produit;
	private Categorie cat;

	private static final long serialVersionUID = 1L;

	public Sous_Categorie() {
		super();
	}

	public Sous_Categorie(String nom) {
		this.nom = nom;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@OneToMany(mappedBy = "s_cat", cascade = CascadeType.ALL)
	public List<Prod> getProduit() {
		return produit;
	}

	public void setProduit(List<Prod> produit) {
		this.produit = produit;
	}

	@ManyToOne
	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	@Override
	public boolean equals(Object other) {
		return (other instanceof Sous_Categorie) && (this.nom != null) ? this.nom
				.equals(((Sous_Categorie) other).nom) : (other == this);
	}

	@Override
	public int hashCode() {
		return (this.nom != null) ? (getClass().hashCode() + nom.hashCode())
				: super.hashCode();
	}

}
