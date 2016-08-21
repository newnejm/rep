package com.yesserp.domain.gs;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Catégorie
 * 
 */
@Entity
@Table(name = "gs_categ")
public class Categorie implements Serializable {

	private int id;
	private String nom;

	private List<Sous_Categorie> s_cat;
	private List<Prod> produit;

	private static final long serialVersionUID = 1L;

	public Categorie() {
		super();
	}

	public Categorie(String nom) {
		this.nom = nom;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
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

	@OneToMany(mappedBy = "cat", cascade = CascadeType.ALL)
	public List<Prod> getProduit() {
		return produit;
	}

	public void setProduit(List<Prod> produit) {
		this.produit = produit;
	}

	@OneToMany(mappedBy = "cat", cascade = CascadeType.ALL)
	public List<Sous_Categorie> getS_cat() {
		return s_cat;
	}

	public void setS_cat(List<Sous_Categorie> s_cat) {
		this.s_cat = s_cat;
	}

	@Override
	public boolean equals(Object other) {
		return (other instanceof Categorie) && (this.nom != null) ? this.nom
				.equals(((Categorie) other).nom) : (other == this);
	}

	@Override
	public int hashCode() {
		return (this.nom != null) ? (getClass().hashCode() + nom.hashCode())
				: super.hashCode();
	}

}
